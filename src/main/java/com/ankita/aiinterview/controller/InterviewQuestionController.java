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
import com.ankita.aiinterview.service.InterviewQuestionService;

@RestController
@RequestMapping("/api/questions")
public class InterviewQuestionController {

private final InterviewQuestionService service;
  public InterviewQuestionController(
        InterviewQuestionService service) {

    this.service = service;
}
    @PostMapping
    public InterviewQuestion saveQuestion(
            @RequestBody InterviewQuestion question) {

        return service.saveQuestion(question);
    }

    @GetMapping
    public List<InterviewQuestion> getAllQuestions() {

        return service.getAllQuestions();
    }

    @PutMapping("/{id}")
public InterviewQuestion updateQuestion(
        @PathVariable Long id,
        @RequestBody InterviewQuestion updatedQuestion) {
return service.updateQuestion(id,
                              updatedQuestion);

        }


@DeleteMapping("/{id}")
public String deleteQuestion(@PathVariable Long id) {

service.deleteQuestion(id);

return "Question Deleted Successfully";

}
@GetMapping("/category/{category}")
public List<InterviewQuestion> getByCategory(
        @PathVariable String category) {
return service.getByCategory(category);
}
@GetMapping("/difficulty/{difficulty}")
public List<InterviewQuestion> getByDifficulty(
        @PathVariable String difficulty) {

    return service.getByDifficulty(difficulty);
}
}
