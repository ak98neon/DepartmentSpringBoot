package com.ak98neon.departmentspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private static final String INDEX_MAPPING = "index";

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        return INDEX_MAPPING;
    }
}
