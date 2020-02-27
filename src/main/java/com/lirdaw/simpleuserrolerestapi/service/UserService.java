package com.lirdaw.simpleuserrolerestapi.service;

import com.lirdaw.simpleuserrolerestapi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int idUser);

    void save(User user);

    void deleteById(int idUser);
}
