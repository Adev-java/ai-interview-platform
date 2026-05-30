package com.ankita.aiinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.aiinterview.entity.InterviewQuestion;
import com.ankita.aiinterview.repository.InterviewQuestionRepository;

@RestController
@RequestMapping("/api/questions")
public class InterviewQuestionController {

    private final InterviewQuestionRepository repository;

    public InterviewQuestionController(
            InterviewQuestionRepository repository) {

        this.repository = repository;
    }

    @PostMapping
    public InterviewQuestion saveQuestion(
            @RequestBody InterviewQuestion question) {

        return repository.save(question);
    }

    @GetMapping
    public List<InterviewQuestion> getAllQuestions() {

        return repository.findAll();
    }
}
