package com.nihao.elastic_demo.elasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

public class ElasticIndexerTest {

    private static final String INDEX_NAME = "my_index";
    private static final String TYPE_NAME = "_doc";

    public static void main(String[] args) {
        try (RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder("192.168.56.10:9200"))) { 这个是集群的方式
            RestClient.builder(new HttpHost("192.168.56.10", 9200, "http")))) {

            // 准备数据
            for (int i = 1; i <= 100; i++) {
                String jsonData = "{\"title\": \"Document " + i + "\", \"content\": \"This is document number " + i + ".\"}";

                // 准备索引请求
                IndexRequest request = new IndexRequest(INDEX_NAME, TYPE_NAME)
                        .source(jsonData, XContentType.JSON);

                // 发送索引请求
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
                System.out.println("Indexed document " + response.getId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
