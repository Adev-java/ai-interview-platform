package com.ankita.aiinterview.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ankita.aiinterview.dto.QuestionRequest;
import com.ankita.aiinterview.entity.InterviewQuestion;
import com.ankita.aiinterview.exception.QuestionNotFoundException;
import com.ankita.aiinterview.repository.InterviewQuestionRepository;
import com.ankita.aiinterview.service.InterviewQuestionService;
@Service
public class InterviewQuestionServiceImpl
        implements InterviewQuestionService {

    private final InterviewQuestionRepository repository;

    public InterviewQuestionServiceImpl(
            InterviewQuestionRepository repository) {

        this.repository = repository;
    }

    @Override
public InterviewQuestion saveQuestion(
        QuestionRequest request) {

    InterviewQuestion question =
            new InterviewQuestion();

    question.setCategory(
            request.getCategory());

    question.setQuestion(
            request.getQuestion());

    question.setDifficulty(
            request.getDifficulty());

    return repository.save(question);
}
    @Override
    public List<InterviewQuestion> getAllQuestions() {

        return repository.findAll();
    }

    @Override
    public InterviewQuestion updateQuestion(
            Long id,
            InterviewQuestion updatedQuestion) {

        InterviewQuestion question =
                repository.findById(id)
                        .orElseThrow(() ->
        new QuestionNotFoundException(
                "Question not found"));

        question.setCategory(
                updatedQuestion.getCategory());

        question.setQuestion(
                updatedQuestion.getQuestion());

        question.setDifficulty(
                updatedQuestion.getDifficulty());

        return repository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<InterviewQuestion> getByCategory(
            String category) {

        return repository.findByCategory(category);
    }

    @Override
    public List<InterviewQuestion> getByDifficulty(
            String difficulty) {

        return repository.findByDifficulty(difficulty);
    }
}