package com.ankita.aiinterview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.aiinterview.dto.FeedbackRequest;
import com.ankita.aiinterview.service.GeminiService;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final GeminiService geminiService;

    public AiController( GeminiService geminiService) {

        this.geminiService = geminiService;
    }

    @PostMapping("/feedback")
    public String getFeedback(
             @RequestBody FeedbackRequest request) {
    return geminiService.getFeedback(
                request.getQuestion(),
                request.getAnswer());

    }
}