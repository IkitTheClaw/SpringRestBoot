package com.example.springrestboot.controller;

import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import com.example.springrestboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, Model model) {

        User user = userService.getUserById(id);
        logger.info("User --> " + user);
        model.addAttribute("user",user);

        return "userUpdatePage";
    }
}
