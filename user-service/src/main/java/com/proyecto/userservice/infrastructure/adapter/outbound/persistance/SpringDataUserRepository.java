package com.proyecto.userservice.infrastructure.adapter.outbound.persistance;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataUserRepository extends  JpaRepository<UserEntity, UUID> {
  Optional<UserEntity> findByEmail(String email);
}
