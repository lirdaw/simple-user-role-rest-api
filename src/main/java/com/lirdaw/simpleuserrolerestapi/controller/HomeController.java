package com.lirdaw.simpleuserrolerestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    String getHome() {
        return "index";
    }
}
