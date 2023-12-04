package com.example.springrestboot.mapper;

import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserRegistrationDTO;
import com.example.springrestboot.services.RoleService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User toUser(UserRegistrationDTO userDto) {
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword()

        );
    }
}
