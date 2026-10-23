package com.proyecto.userservice.infrastructure.adapter.inbound.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.domain.port.inbound.CreateUserUseCase;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final CreateUserUseCase createUserUseCase;

  public UserController(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping
  public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
    User userDomain = UserRestMapper.toDomain(requestDto);
    User createdUser = createUserUseCase.createUser(userDomain);
    UserResponseDto responseDto = UserRestMapper.toResponseDto(createdUser);

    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
  }

}
