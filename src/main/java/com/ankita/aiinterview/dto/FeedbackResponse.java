package com.ankita.aiinterview.dto;

public class FeedbackResponse {

    private final int score;
    private final String feedback;

    public FeedbackResponse(int score,
                            String feedback) {

        this.score = score;
        this.feedback = feedback;
    }

    public int getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }
}