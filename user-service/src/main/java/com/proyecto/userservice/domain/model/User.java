package com.proyecto.userservice.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class User {
  private UUID id;
  private String name;
  private String email;
  private String password;
  private List<Address> addresses;
  private LocalDateTime createdAt;

  public User(UUID id, String name, String email, String password, List<Address> addresses, LocalDateTime createdAt) {
    this.id = id != null ? id : UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
    this.addresses = addresses;
    this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
  }

  public UUID getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getPassword() { return password; }
  public List<Address> getAddresses() { return addresses; }
  public LocalDateTime getCreatedAt() { return createdAt; }
}
