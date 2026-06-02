package com.ankita.aiinterview.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            QuestionNotFoundException.class)
    public ResponseEntity<String>
    handleQuestionNotFound(
            QuestionNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(
        MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>>
handleValidation(
        MethodArgumentNotValidException ex) {

    Map<String, String> errors =
            new HashMap<>();

    ex.getBindingResult()
            .getFieldErrors()
            .forEach(error ->
                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()));

    return new ResponseEntity<>(
            errors,
            HttpStatus.BAD_REQUEST);
}
}