package com.proyecto.userservice.infrastructure.adapter.inbound.rest;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserResponseDto {
  private UUID id;
  private String name;
  private String email;
  private LocalDateTime createdAt;


  public UserResponseDto(UUID id, String name, String email, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.createdAt = createdAt;
  }

  public UUID getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public LocalDateTime getCreatedAt() { return createdAt; }


}
