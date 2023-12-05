package com.example.springrestboot.controller;

import com.example.springrestboot.model.Role;
import com.example.springrestboot.model.User;
import com.example.springrestboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class UserRestController {
    private final UserService userService;


    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "word",required = false) String word) {
        if(word == null) {
        return ResponseEntity.ok(userService.getAllUsers());
        } else {
            return ResponseEntity.ok(userService.searchUser(word));
        }
    }

    @GetMapping("/save")
    public ResponseEntity<User> save(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam Set<Role> roles)
        {
        User user = new User(name, email, password,roles);
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {

            userService.deleteUserByUserid(id);
            return ResponseEntity.status(HttpStatus.OK).body("Пользователь удалён");
        }

        @GetMapping("/findUserByName/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }


}
