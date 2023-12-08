package com.example.springrestboot.controller;

import com.example.springrestboot.mapper.UserMapper;
import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import com.example.springrestboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AdminRestController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public AdminRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "word", required = false) String word) {
        if (word == null) {
            return ResponseEntity.ok(userService.getAllUsers());
        } else {
            return ResponseEntity.ok(userService.searchUser(word));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
        // Создаем нового пользователя
        User newUser = userMapper.toUser(userDTO);
        userService.save(newUser); // Сохраняем пользователя в базе данных
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserByUserid(id);
        return ResponseEntity.status(HttpStatus.OK).body("Пользователь удалён");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user){
        User updatingUser = userService.getUserById(id);

        if (updatingUser != null) {
            updatingUser.setName(user.getName());
            updatingUser.setEmail(user.getEmail());
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                updatingUser.setPassword(user.getPassword());
            }
        userService.save(updatingUser);
        }
        return ResponseEntity.ok("Пользователь обновлён");
    }
    //сделать форму обновления
    //разделить USER и ADMIN контроллеры
    // ...
}
