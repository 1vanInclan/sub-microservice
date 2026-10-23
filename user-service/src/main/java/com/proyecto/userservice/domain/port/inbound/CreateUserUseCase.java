package com.proyecto.userservice.domain.port.inbound;

import com.proyecto.userservice.domain.model.User;

public interface CreateUserUseCase {
  User createUser(User user);
}
