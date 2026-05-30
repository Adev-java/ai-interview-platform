package com.ankita.aiinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankita.aiinterview.entity.InterviewQuestion;

public interface InterviewQuestionRepository
        extends JpaRepository<InterviewQuestion, Long> {
}