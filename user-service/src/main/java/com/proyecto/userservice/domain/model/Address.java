package com.proyecto.userservice.domain.model;

import java.util.UUID;

public class Address {
  private UUID id;
  private String street;
  private String city;
  private String zipCode;
  private String country;
  private Boolean isDefault;


  public Address(UUID id, String street, String city, String zipCode, String country, Boolean isDefault) {
    this.id = id != null ? id : UUID.randomUUID();
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
    this.country = country;
    this.isDefault = isDefault;
  }

  public UUID getId() { return id; }
  public String getStreet() { return street; }
  public String getCity() { return city; }
  public String getZipCode() { return zipCode; }
  public String getCountry() { return country; }
  public Boolean getisDefault() {return isDefault; }

}
