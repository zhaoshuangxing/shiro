package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by first on 2017/06/14.
 */
@Controller
public class IndexController {

    @RequestMapping("list")
    public String getList() {
        return "list";
    }
}
