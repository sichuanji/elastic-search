package com.nihao.elastic_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RootPathController {

    @GetMapping("/")
    public String getRootPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String rootPath = request.getRequestURL().toString().replace(request.getRequestURI(), contextPath);
        return "Root Path: " + rootPath;
    }
}
