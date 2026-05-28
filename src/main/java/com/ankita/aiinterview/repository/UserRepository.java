package com.ankita.aiinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankita.aiinterview.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
