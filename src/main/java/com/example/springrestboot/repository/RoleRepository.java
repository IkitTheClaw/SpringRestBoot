package com.example.springrestboot.repository;

import com.example.springrestboot.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Optional<Role> findByName(String name);
    List<Role> findAll();
}