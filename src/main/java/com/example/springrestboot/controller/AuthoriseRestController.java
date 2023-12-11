package com.example.springrestboot.controller;

import com.example.springrestboot.mapper.UserMapper;
import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import com.example.springrestboot.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth" )
public class AuthoriseRestController {
    private final String USER_ROLE = "USER";
    private final UserMapper userMapper;
    private final UserService userService;

    public AuthoriseRestController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("/save" )
    public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
        // Создаем нового пользователя
        User newUser = userMapper.toUser(userDTO, USER_ROLE);
        userService.save(newUser); // Сохраняем пользователя в базе данных
        return ResponseEntity.ok("Пользователь успешно зарегистрирован" );
    }


}
