package com.ankita.aiinterview.service;

import java.util.List;

import com.ankita.aiinterview.entity.InterviewQuestion;

public interface InterviewQuestionService {

    InterviewQuestion saveQuestion(InterviewQuestion question);

    List<InterviewQuestion> getAllQuestions();

    InterviewQuestion updateQuestion(Long id,
                                     InterviewQuestion question);

    void deleteQuestion(Long id);

    List<InterviewQuestion> getByCategory(String category);

    List<InterviewQuestion> getByDifficulty(String difficulty);
}