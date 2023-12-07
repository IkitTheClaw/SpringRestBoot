package com.example.springrestboot.mapper;

import com.example.springrestboot.exceptions.RoleNotFoundException;
import com.example.springrestboot.model.User;
import com.example.springrestboot.model.dto.UserDTO;
import com.example.springrestboot.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {
    private final RoleService roleService;
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User toUser(UserDTO userDto) {
        logger.info("toUser <--" + userDto);
        return new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                Set.of(roleService.findByName(userDto.getRole()).orElseThrow(() -> new RoleNotFoundException("нет такой роли")))

        );
    }
}
