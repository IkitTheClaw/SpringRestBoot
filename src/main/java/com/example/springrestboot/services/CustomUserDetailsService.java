package com.example.springrestboot.services;

import com.example.springrestboot.model.User;
import com.example.springrestboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // Поиск пользователя по имени
        logger .info("loadUserByUsername <-- " + name);
        System.out.println("hello nigga" + name);
        User user = userRepository.findUserByName(name);
        System.out.println("hello another nigga");
        if (user == null) {
            throw new UsernameNotFoundException("User not found with name: " + name);
        }
        // Создание UserDetails объекта с использованием полей "name" и "email" пользователя
        return user;
    }
}
