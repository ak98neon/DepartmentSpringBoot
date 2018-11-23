package com.ak98neon.departmentspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private static final String INDEX_MAPPING = "index";

    public String index() {
        return INDEX_MAPPING;
    }
}
