package com.ankita.aiinterview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankita.aiinterview.entity.User;
import com.ankita.aiinterview.repository.UserRepository;
import com.ankita.aiinterview.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}