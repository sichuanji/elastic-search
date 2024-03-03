package com.nihao.elastic_demo.controller;// 在 Spring Boot 项目中的 Controller 类中添加以下代码

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.client.RestClient;

@RestController
public class SearchController {


    private RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("192.168.56.10", 9200, "http")
            )
    );
//    public SearchController(RestHighLevelClient client) {
//        this.client = client;
//    }

    @GetMapping("/search")
    public String search() {
        try {
            SearchRequest searchRequest = new SearchRequest("my_index");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.matchQuery("content", "document"));
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            return searchResponse.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
