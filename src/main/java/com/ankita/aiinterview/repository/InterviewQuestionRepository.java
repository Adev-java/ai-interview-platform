package com.ankita.aiinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankita.aiinterview.entity.InterviewQuestion;

public interface InterviewQuestionRepository
        extends JpaRepository<InterviewQuestion, Long> {

    public List<InterviewQuestion> findByCategory(String category);

    List<InterviewQuestion> findByDifficulty(String difficulty);

}
