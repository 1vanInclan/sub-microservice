package com.proyecto.userservice.application.port.out;

import java.util.Optional;
import java.util.UUID;

import com.proyecto.userservice.domain.model.User;

public interface UserRepositoryPort {
  User save(User user);
  Optional<User> findById(UUID id);
  Optional<User> findByEmail(String email);
}
