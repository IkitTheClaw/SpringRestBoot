package com.example.springrestboot.services;

import com.example.springrestboot.model.User;

import java.util.List;
//общее описание логики приложения ->
public interface UserService {
    User getUserById(Long id);
    //логика получения пользователя по id

    User getUserByName(String name);
    //логика получения пользователя по имени

    List<User> getAllUsers();
    //логика получения полного списка пользователей

    User save(User user);
    //логика сохранения пользователя в бд

    void deleteUserByUserid(long id);
    //логика удаления пользователя из бд
    List<User> searchUser(String word);
}
