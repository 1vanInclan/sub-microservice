package com.proyecto.userservice.application.port.in;

import java.util.UUID;

import com.proyecto.userservice.domain.model.User;

public interface GetUserUseCase {
  User getUserById(UUID id);
}
