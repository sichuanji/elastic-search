package com.nihao.elastic_demo.controller;

import com.nihao.elastic_demo.dto.ProductSearch;
import com.nihao.elastic_demo.entity.Bidding_application;
import com.nihao.elastic_demo.elasticSearch.ElasticProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchKeyWordsController {
    @Autowired
    ElasticProductService elasticProductService;
    //配置跨域请求
    @CrossOrigin
    @GetMapping("/searchByKey")
    public List<ProductSearch> searchByKey(String term) {

        System.out.println(term);
        return elasticProductService.searchProducts(term);


    }
}
