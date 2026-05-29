
package com.ankita.aiinterview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankita.aiinterview.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}