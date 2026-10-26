package com.proyecto.userservice.infrastructure.adapter.in.rest;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.userservice.application.port.in.CreateUserUseCase;
import com.proyecto.userservice.application.port.in.GetUserUseCase;
import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.infrastructure.adapter.in.rest.dto.CreateUserRequest;

@RestController
@RequestMapping ("/api/v1/users")
public class UserController {
  private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        User createdUser = createUserUseCase.createUser(
                request.name(),
                request.email(),
                request.password(),
                request.getDomainAddresses()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        User user = getUserUseCase.getUserById(id);
        return ResponseEntity.ok(user);
    }
}
