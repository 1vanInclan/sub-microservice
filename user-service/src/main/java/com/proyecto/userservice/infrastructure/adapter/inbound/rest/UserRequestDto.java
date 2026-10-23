package com.proyecto.userservice.infrastructure.adapter.inbound.rest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDto {

  @NotBlank(message = "El nombre es obligatorio")
  private String name;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "Debe ser un email valido")
  private String email;

  @NotBlank(message = "La contrasenia es obligatoria")
  @Size(min = 6, message = "La contrasenia debe tener al menos 6 caracteres")
  private String password;

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }

}
