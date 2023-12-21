package com.example.springrestboot.controller;

import com.example.springrestboot.mapper.UserMapper;
import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import com.example.springrestboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "word", required = false) String word) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return ResponseEntity.ok(List.of(userService.getUserByName(auth.getName())));
    }

    @DeleteMapping("/delete/{id}")
    public RedirectView deleteUserById(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();       // проверить защиту
        userService.deleteUserByUserid(userService.getUserByName(auth.getName()).getId());
        return new RedirectView("/login");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateUser(@PathVariable Long id, @ModelAttribute ("user") User user ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User updatingUser = (User) auth.getPrincipal();
        if (updatingUser != null) {
            updatingUser.setName(user.getName());
            updatingUser.setEmail(user.getEmail());
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                updatingUser.setPassword(user.getPassword());
            }
            userService.save(updatingUser);
        }

        return new RedirectView("/user");
    }
}