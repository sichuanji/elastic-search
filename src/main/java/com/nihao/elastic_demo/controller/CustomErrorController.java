package com.nihao.elastic_demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//路径没对呀，是以application为标准，日本人
@RestController
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // 返回自定义的错误页面路径
        return "error";
    }

}
