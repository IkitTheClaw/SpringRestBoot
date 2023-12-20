package com.example.springrestboot.repository;

import com.example.springrestboot.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);

    //получение пользователя из бд по id
    User findUserByName(String name);

    //получение пользователя из бд по имени
    List<User> findAll();

    //получение полного списка пользователей из бд
    User save(User user);

    //сохранение пользователя в бд
    void deleteUserById(long id);
    //удаление пользователя из бд
    List<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrderByName(String name,String email);
}
