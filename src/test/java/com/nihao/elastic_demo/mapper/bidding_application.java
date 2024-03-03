package com.nihao.elastic_demo.mapper;

import com.nihao.elastic_demo.dao.BiddingApplicationMapper;
import com.nihao.elastic_demo.entity.Bidding_application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class bidding_application {
    // @Resource为javaee原生的 查找方式不同 一个是名字 然后类型 一个是类型
    @Autowired
    BiddingApplicationMapper biddingApplicationMapper;
    @Test
    void selectTest(){
        if(biddingApplicationMapper==null) System.out.println("出现空指针");
        else {
            List<Bidding_application> li = biddingApplicationMapper.findAll();
            for (Bidding_application ba :
                    li) {
                System.out.println(li.toString());
            }
        }
    }
}
