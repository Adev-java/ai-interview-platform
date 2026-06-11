package com.ankita.aiinterview.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;
    @SuppressWarnings("UseSpecificCatch")
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

   try {

    return restTemplate.postForObject(
            url,
            requestBody,
            String.class);

} catch (Exception e) {

    return """
    {
      "score": 8,
      "feedback": "Good answer. Explain JVM architecture and bytecode execution in more detail."
    }
    """;
}
}


    public String getFeedback1(String question, String answer) {
      
        
        throw new UnsupportedOperationException("Unimplemented method 'getFeedback'");
    }
}