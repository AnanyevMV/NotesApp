package com.ananyevmv.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * Метод-обработчик ошибок
     */
    @ExceptionHandler
    public ResponseEntity<?> handleException(Throwable throwable) {
        Map<String, String> responseBody = Map.of("Error message", throwable.getMessage());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}
