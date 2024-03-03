package com.nihao.elastic_demo.controller;

import com.nihao.elastic_demo.dao.BiddingApplicationMapper;
import com.nihao.elastic_demo.elasticSearch.ElasticProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushProductData {

    @Autowired
    ElasticProductService elasticProductService;
    @Autowired
    BiddingApplicationMapper biddingApplicationMapper;

    @GetMapping("/push")
    public String search(String name) {
        elasticProductService.uploadDataToElasticsearch(

                biddingApplicationMapper.findAll()

        );
        return "已经上传";


    }
}

