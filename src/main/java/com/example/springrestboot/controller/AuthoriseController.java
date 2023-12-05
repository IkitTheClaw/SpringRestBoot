package com.example.springrestboot.controller;

import com.example.springrestboot.mapper.UserMapper;
import com.example.springrestboot.model.dto.UserRegistrationDTO;
import com.example.springrestboot.model.User;
import com.example.springrestboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AuthoriseController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public AuthoriseController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }




    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {

        // Создаем нового пользователя
        User newUser = userMapper.toUser(userRegistrationDTO);



        userService.save(newUser); // Сохраняем пользователя в базе данных

        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }
}


