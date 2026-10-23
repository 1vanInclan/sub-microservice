package com.proyecto.userservice.domain.port.outbound;

import java.util.Optional;
import java.util.UUID;

import com.proyecto.userservice.domain.model.User;

public interface UserRepositoryPort {
  User save(User user);
  Optional<User> findById(UUID id);
  Optional<User> findByEmail(String email);
}
