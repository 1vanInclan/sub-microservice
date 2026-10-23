package com.proyecto.userservice.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.userservice.application.service.UserService;
import com.proyecto.userservice.domain.port.outbound.UserRepositoryPort;

@Configuration
public class BeanConfig {

  @Bean
  public UserService userService(UserRepositoryPort userRepositoryPort) {
    return new UserService(userRepositoryPort);
  }
}
