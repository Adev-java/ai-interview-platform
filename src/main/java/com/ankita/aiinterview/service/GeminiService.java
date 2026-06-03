package com.ankita.aiinterview.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;
public String getFeedback(
        String question,
        String answer) {

    String prompt =
            "Question: " + question +
            "\nAnswer: " + answer +
            "\nGive interview feedback with score and improvements.";

    String url =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key="
                    + apiKey;

    RestTemplate restTemplate = new RestTemplate();

    String requestBody = """
    {
      "contents": [{
        "parts": [{
          "text": "%s"
        }]
      }]
    }
    """.formatted(prompt.replace("\"", "\\\""));

    return restTemplate.postForObject(
            url,
            requestBody,
            String.class);
}
    public String getFeedback1(String question, String answer) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getFeedback'");
    }
}