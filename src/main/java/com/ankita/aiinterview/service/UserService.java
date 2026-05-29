package com.ankita.aiinterview.service;

import com.ankita.aiinterview.dto.LoginRequest;
import com.ankita.aiinterview.dto.RegisterRequest;
import com.ankita.aiinterview.entity.User;

public interface UserService {

    User registerUser(RegisterRequest request);

    String loginUser(LoginRequest request);
}