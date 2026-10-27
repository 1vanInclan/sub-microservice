package com.proyecto.subscription_service.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proyecto.subscription_service.domain.exception.SubscriptionNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(SubscriptionNotFoundException.class)
  public ResponseEntity<Object> handleSubscriptionNotFound(SubscriptionNotFoundException ex) {
    Map<String, Object> body = Map.of(
      "timestamp", LocalDateTime.now(),
      "status", HttpStatus.NOT_FOUND.value(),
      "error", "Not Found",
      "message", ex.getMessage()
    );
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }


}
