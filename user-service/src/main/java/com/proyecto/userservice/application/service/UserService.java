package com.proyecto.userservice.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.domain.port.inbound.CreateUserUseCase;
import com.proyecto.userservice.domain.port.outbound.UserRepositoryPort;

public class UserService implements CreateUserUseCase {


  private final UserRepositoryPort userRepositoryPort;

  public UserService(UserRepositoryPort userRepositoryPort) {
    this.userRepositoryPort = userRepositoryPort;
  }

  @Override
  public User createUser(User user) {
    User newUser = new User(
      user.getId() != null ? user.getId() : UUID.randomUUID(),
      user.getName(),
      user.getEmail(),
      user.getPassword(),
      LocalDateTime.now()
    );
    return userRepositoryPort.save(newUser);
  }

}
