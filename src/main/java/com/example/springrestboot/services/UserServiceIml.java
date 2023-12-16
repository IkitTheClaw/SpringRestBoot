package com.example.springrestboot.services;

import com.example.springrestboot.exceptions.UserNotFoundExceprion;
import com.example.springrestboot.model.User;
import com.example.springrestboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceIml implements UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public final User getUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundExceprion("user not found with id = " + id));
    }
    //реализация метода возвращающего пользователя по id

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }
    //Реализация метода возвращающего пользователя по имени

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //реализация метода возвращающего полный список пользователей

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    //реализация метода сохраняющий пользователя в бд

    @Override
    public void deleteUserByUserid(long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public List<User> searchUser(String word) {
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByName(word, word);
    }
    //реализация метода удаляющего пользователя из бд
}
