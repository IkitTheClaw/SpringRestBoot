package com.example.springrestboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StarterPageController {
    @GetMapping("/admin")
    public String getAdminMainPage() {
        return "admin";
    }

    @GetMapping("/user")
    public String getUserMainPage() {
        return "user";
    }
}
