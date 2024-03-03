package com.nihao.elastic_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.nihao.elastic_demo.dao")
public class ElasticDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticDemoApplication.class, args);
    }
}
