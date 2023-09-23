package com.shimada.pastebin.services;

import com.shimada.pastebin.entity.User;
import com.shimada.pastebin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        var users = userRepository.findById(userId);
        return users.get();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
