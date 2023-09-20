package com.shimada.pastebin.services;

import com.shimada.pastebin.Entity.User;
import com.shimada.pastebin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity save(User user) {
        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
}
