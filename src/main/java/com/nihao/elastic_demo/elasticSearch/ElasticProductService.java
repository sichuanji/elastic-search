package com.nihao.elastic_demo.elasticSearch;

import com.nihao.elastic_demo.dto.ProductSearch;
import com.nihao.elastic_demo.entity.Bidding_application;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ElasticProductService {

    private static final String INDEX_NAME = "product_index";
    private final RestHighLevelClient client;

    public ElasticProductService() {
        this.client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.10", 9200, "http")));
    }

    public void uploadDataToElasticsearch(List<Bidding_application> dataList) {
        for (Bidding_application data : dataList) {
            try {
                IndexRequest request = new IndexRequest(INDEX_NAME);
                request.source(createJsonSource(data), XContentType.JSON);
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
                // Handle response if needed
            } catch (IOException e) {
                e.printStackTrace();
                // Handle exception
            }
        }
    }

    private String createJsonSource(Bidding_application data) {
        // Create a JSON object representing the document to be indexed
        // You can map your database fields to Elasticsearch document fields here
        // For example:
        return "{"
                + "\"purid\":\"" + data.getPurid() + "\","
                + "\"product_name\":\"" + data.getProduct_name() + "\","
                + "\"prescribe\":\"" + data.getPrescribe() + "\""
                // Add other fields here
                + "}";
    }

    public List<ProductSearch> searchProducts(String keyword) {
        List<ProductSearch> resultList = new ArrayList<>();
        System.out.println(keyword);
        try {
            // 创建搜索请求
            SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

            // 设置查询条件
            sourceBuilder.query(QueryBuilders.multiMatchQuery(keyword, "product_name"));
//            sourceBuilder.query(QueryBuilders.multiMatchQuery(keyword, "purid", "product_name", "prescribe"));
            // Add other fields here if needed

            // 设置超时时间
            sourceBuilder.timeout(new TimeValue(60_000));

            // 执行搜索请求
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            // 处理搜索结果
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                ProductSearch product = new ProductSearch();
//                product.setPurid(Integer.parseInt(sourceAsMap.get("purid")));
                product.setPurid(Integer.valueOf(sourceAsMap.get("purid").toString()));
                product.setProduct_name((String) sourceAsMap.get("product_name"));
                product.setPrescribe((String) sourceAsMap.get("prescribe"));
                // Add other fields here if needed
                resultList.add(product);
                System.out.println(product.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
