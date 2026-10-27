package com.proyecto.subscription_service.domain.exception;

import java.util.UUID;

public class SubscriptionNotFoundException extends RuntimeException{
  public SubscriptionNotFoundException(UUID id) {
    super("Subscription with id" + id + " not found");
  }
}
