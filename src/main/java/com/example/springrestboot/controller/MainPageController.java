package com.example.springrestboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@RestController
public class MainPageController {
    @GetMapping
    public ModelAndView getMainPage() {
        return new ModelAndView("main");
    }
}
