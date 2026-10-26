package com.proyecto.userservice.infrastructure.adapter.out.persistence.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Addresses")
public class AddressEntity {


  @Id
  private UUID id;
  
  @Column(nullable = false)
  private String street;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false, name = "zip_code")
  private String zipCode;

  @Column(nullable = false)
  private String country;

  @Column(nullable = false, name = "is_default")
  private Boolean isDefault;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  public AddressEntity() {}

  public AddressEntity(UUID id, String street, String city, String zipCode, String country, boolean isDefault) {
      this.id = id;
      this.street = street;
      this.city = city;
      this.zipCode = zipCode;
      this.country = country;
      this.isDefault = isDefault;
  }

  // Getters y Setters
  public UUID getId() { return id; }
  public void setId(UUID id) { this.id = id; }
  public String getStreet() { return street; }
  public void setStreet(String street) { this.street = street; }
  public String getCity() { return city; }
  public void setCity(String city) { this.city = city; }
  public String getZipCode() { return zipCode; }
  public void setZipCode(String zipCode) { this.zipCode = zipCode; }
  public String getCountry() { return country; }
  public void setCountry(String country) { this.country = country; }
  public boolean isDefault() { return isDefault; }
  public void setDefault(boolean aDefault) { isDefault = aDefault; }
  public void setUser(UserEntity user) { this.user = user; }

}
