package com.ankita.aiinterview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankita.aiinterview.dto.RegisterRequest;
import com.ankita.aiinterview.entity.User;
import com.ankita.aiinterview.repository.UserRepository;
import com.ankita.aiinterview.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }
}