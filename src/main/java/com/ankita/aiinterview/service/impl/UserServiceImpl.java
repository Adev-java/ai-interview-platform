
package com.ankita.aiinterview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ankita.aiinterview.dto.LoginRequest;
import com.ankita.aiinterview.dto.RegisterRequest;
import com.ankita.aiinterview.entity.User;
import com.ankita.aiinterview.repository.UserRepository;
import com.ankita.aiinterview.service.UserService;
import com.ankita.aiinterview.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User registerUser(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public String loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean isPasswordCorrect =
                passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!isPasswordCorrect) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}