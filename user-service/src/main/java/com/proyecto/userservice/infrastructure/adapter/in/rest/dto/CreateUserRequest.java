package com.proyecto.userservice.infrastructure.adapter.in.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.userservice.domain.model.Address;

public record CreateUserRequest(
  String name,
  String email,
  String password,
  List<AddressRequest> addresses
) {
  public record AddressRequest(
    String street,
    String city,
    String zipCode,
    String country,
    boolean isDefault
  ) {

    public Address toDomain() {
      return new Address(null, street, city, zipCode, country, isDefault);
    }
  }

    public List<Address> getDomainAddresses() {
      if (addresses == null) return List.of();
      return addresses.stream()
        .map(AddressRequest::toDomain)
        .collect(Collectors.toList());
    }
  }

