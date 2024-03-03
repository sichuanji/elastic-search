package com.nihao.elastic_demo.controller;

import com.nihao.elastic_demo.dao.BiddingApplicationMapper;
import com.nihao.elastic_demo.entity.Bidding_application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//测试数据库连接
@RestController
public class GetBAList {
    @Autowired
    BiddingApplicationMapper biddingApplicationMapper;
    @GetMapping("/select")
    public List<Bidding_application> select() {
        // 返回自定义的错误页面路径
        return biddingApplicationMapper.findAll();
    }

}
