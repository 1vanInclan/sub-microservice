package com.proyecto.userservice.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.proyecto.userservice.application.port.in.CreateUserUseCase;
import com.proyecto.userservice.application.port.in.GetUserUseCase;
import com.proyecto.userservice.application.port.out.UserRepositoryPort;
import com.proyecto.userservice.domain.exception.UserAlreadyExistsException;
import com.proyecto.userservice.domain.exception.UserNotFoundException;
import com.proyecto.userservice.domain.model.Address;
import com.proyecto.userservice.domain.model.User;


@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

  private final UserRepositoryPort userRepositoryPort;

  public UserService(UserRepositoryPort userRepositoryPort) {
    this.userRepositoryPort = userRepositoryPort;
  }

  @Override
  public User createUser(String name, String email, String password, List<Address> addresses) {

    if (userRepositoryPort.findByEmail(email).isPresent()) {
      throw new UserAlreadyExistsException("El correo electronico" + email + " ya se encuentra registrado");
    }

    User newUser = new User(null, name, email, password, addresses, null);

    return userRepositoryPort.save(newUser);

  }

  @Override
  public User getUserById(UUID id) {
    return userRepositoryPort.findById(id)
      .orElseThrow(() -> new UserNotFoundException("No se encontro ningun usuario con el ID: " + id));
  }


}
