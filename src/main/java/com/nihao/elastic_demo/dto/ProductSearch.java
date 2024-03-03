package com.nihao.elastic_demo.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProductSearch {
    private Integer purid;

    private String product_name;

    private String prescribe;
}
