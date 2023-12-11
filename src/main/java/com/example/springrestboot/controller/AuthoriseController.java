package com.example.springrestboot.controller;

import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AuthoriseController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }



}


