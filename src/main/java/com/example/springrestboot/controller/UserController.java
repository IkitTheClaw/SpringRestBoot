package com.example.springrestboot.controller;

import com.example.springrestboot.model.User;
import com.example.springrestboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserMainPage() {
        return "user";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();       // проверить защиту
        User user = userService.getUserById(userService.getUserByName(auth.getName()).getId());
        logger.info("User --> " + user);
        model.addAttribute("user",user);

        return "userUpdatePage";
    }
}
