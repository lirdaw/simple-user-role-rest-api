package com.lirdaw.simpleuserrolerestapi.service;

import com.lirdaw.simpleuserrolerestapi.entity.User;
import com.lirdaw.simpleuserrolerestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements com.lirdaw.simpleuserrolerestapi.service.UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int idUser) {
        Optional<User> result = userRepository.findById(idUser);

        User user;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("There is no user with idUser: " + idUser);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int idUser) {
        userRepository.deleteById(idUser);
    }
}
