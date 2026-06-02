package com.ankita.aiinterview.dto;

import jakarta.validation.constraints.NotBlank;

public class QuestionRequest {

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Question is required")
    private String question;

    @NotBlank(message = "Difficulty is required")
    private String difficulty;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}