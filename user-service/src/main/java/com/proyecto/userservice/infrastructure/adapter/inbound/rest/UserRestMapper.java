package com.proyecto.userservice.infrastructure.adapter.inbound.rest;

import com.proyecto.userservice.domain.model.User;

public class UserRestMapper {
  public static User toDomain(UserRequestDto dto) {
    if (dto == null) return null;
    return new User(
      null,
      dto.getName(),
      dto.getEmail(),
      dto.getPassword(),
      null
    );
  }

  public static UserResponseDto toResponseDto(User user) {
    if (user == null ) return null;
    return new UserResponseDto(
      user.getId(),
      user.getName(),
      user.getEmail(),
      user.getCreatedAt()
    );
  }
}
