package com.springboot.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
