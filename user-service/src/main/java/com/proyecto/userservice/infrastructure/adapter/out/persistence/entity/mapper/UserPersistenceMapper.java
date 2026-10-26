package com.proyecto.userservice.infrastructure.adapter.out.persistence.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.userservice.domain.model.Address;
import com.proyecto.userservice.domain.model.User;
import com.proyecto.userservice.infrastructure.adapter.out.persistence.entity.AddressEntity;
import com.proyecto.userservice.infrastructure.adapter.out.persistence.entity.UserEntity;

public class UserPersistenceMapper {
  public static UserEntity toEntity(User domain) {
        List<AddressEntity> addressEntities = domain.getAddresses() != null ?
                domain.getAddresses().stream().map(addr -> new AddressEntity(
                        addr.getId(),
                        addr.getStreet(),
                        addr.getCity(),
                        addr.getZipCode(),
                        addr.getCountry(),
                        addr.getisDefault()
                )).collect(Collectors.toList()) : null;

        return new UserEntity(
                domain.getId(),
                domain.getName(),
                domain.getEmail(),
                domain.getPassword(),
                addressEntities,
                domain.getCreatedAt()
        );
    }

    public static User toDomain(UserEntity entity) {
        List<Address> addresses = entity.getAddresses() != null ?
                entity.getAddresses().stream().map(addr -> new Address(
                        addr.getId(),
                        addr.getStreet(),
                        addr.getCity(),
                        addr.getZipCode(),
                        addr.getCountry(),
                        addr.isDefault()
                )).collect(Collectors.toList()) : null;

        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                addresses,
                entity.getCreatedAt()
        );
    }
}
