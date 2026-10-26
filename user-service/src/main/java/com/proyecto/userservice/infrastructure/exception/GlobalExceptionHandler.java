package com.proyecto.userservice.infrastructure.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proyecto.userservice.domain.exception.UserAlreadyExistsException;
import com.proyecto.userservice.domain.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {
        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "User Not Found",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<Map<String, Object>> handleUserAlreadyExists(UserAlreadyExistsException ex) {
      Map<String, Object> body = Map.of(
              "timestamp", LocalDateTime.now(),
              "status", HttpStatus.BAD_REQUEST.value(),
              "error", "Bad Request",
              "message", ex.getMessage()
      );
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }
}
