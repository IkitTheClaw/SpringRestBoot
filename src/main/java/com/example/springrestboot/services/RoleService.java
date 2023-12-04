package com.example.springrestboot.services;

import com.example.springrestboot.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional< Role> findByName(String name);
    List<Role> findAll();
}