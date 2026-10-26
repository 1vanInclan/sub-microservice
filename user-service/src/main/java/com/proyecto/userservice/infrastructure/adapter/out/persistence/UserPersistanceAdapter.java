package com.proyecto.userservice.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.proyecto.userservice.application.port.out.UserRepositoryPort;
import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.infrastructure.adapter.out.persistence.entity.UserEntity;
import com.proyecto.userservice.infrastructure.adapter.out.persistence.entity.mapper.UserPersistenceMapper;
import com.proyecto.userservice.infrastructure.adapter.out.persistence.repository.SpringDataUserRepository;

@Repository 
public class UserPersistanceAdapter implements UserRepositoryPort{
  private final SpringDataUserRepository repository;

  public UserPersistanceAdapter(SpringDataUserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User save(User user){
    UserEntity entity = UserPersistenceMapper.toEntity(user);
    UserEntity savedEntity = repository.save(entity);
    return UserPersistenceMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<User> findById(UUID id) {
    return repository.findById(id).map(UserPersistenceMapper::toDomain);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email).map(UserPersistenceMapper::toDomain);
    }

}
