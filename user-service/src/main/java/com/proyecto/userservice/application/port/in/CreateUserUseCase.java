package com.proyecto.userservice.application.port.in;

import java.util.List;

import com.proyecto.userservice.domain.model.Address;
import com.proyecto.userservice.domain.model.User;

public interface CreateUserUseCase {
  User createUser(String name, String email, String password, List<Address> addresses);
}
