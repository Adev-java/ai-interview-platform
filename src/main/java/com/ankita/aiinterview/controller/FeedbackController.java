package com.ankita.aiinterview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.aiinterview.dto.FeedbackRequest;
import com.ankita.aiinterview.dto.FeedbackResponse;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @PostMapping
    public FeedbackResponse getFeedback(
            @RequestBody FeedbackRequest request) {

        int score = request.getAnswer().length() > 50 ? 8 : 5;

        String feedback =
                request.getAnswer().length() > 50
                        ? "Good answer"
                        : "Please explain in more detail";

        return new FeedbackResponse(
                score,
                feedback);
    }
}