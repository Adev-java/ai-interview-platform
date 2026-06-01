package com.ankita.aiinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
public InterviewQuestion updateQuestion(
        @PathVariable Long id,
        @RequestBody InterviewQuestion updatedQuestion) {

    InterviewQuestion question =
            repository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException("Question not found"));

    question.setCategory(updatedQuestion.getCategory());
    question.setQuestion(updatedQuestion.getQuestion());

    return repository.save(question);
}


@DeleteMapping("/{id}")
public String deleteQuestion(@PathVariable Long id) {

    repository.deleteById(id);

    return "Question Deleted Successfully";
}
@GetMapping("/category/{category}")
public List<InterviewQuestion> getByCategory(
        @PathVariable String category) {

    return repository.findByCategory(category);
}
@GetMapping("/difficulty/{difficulty}")
public List<InterviewQuestion> getByDifficulty(
        @PathVariable String difficulty) {

    return repository.findByDifficulty(difficulty);
}
}
