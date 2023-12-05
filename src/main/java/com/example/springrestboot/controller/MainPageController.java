package com.example.springrestboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("hello")
@Controller
public class MainPageController {
    @GetMapping
    public String sayHello() {
        return "helloPage";
    }
}
