package com.proyecto.userservice.infrastructure.adapter.outbound.persistance;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.domain.port.outbound.UserRepositoryPort;


@Component
public class UserPersistenceAdapter implements UserRepositoryPort {
  private final SpringDataUserRepository repository;

  public UserPersistenceAdapter(SpringDataUserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User save(User user) {
    UserEntity entity = UserMapper.toEntity(user);
    UserEntity savedEntity = repository.save(entity);
    return UserMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<User> findById(UUID id){
    return repository.findById(id).map(UserMapper::toDomain);
  }

  @Override
  public Optional<User> findByEmail(String email){
    return repository.findByEmail(email).map(UserMapper::toDomain);
  }
}
