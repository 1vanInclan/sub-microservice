package com.proyecto.subscription_service.application.port.out;

import java.util.Optional;
import java.util.UUID;

import com.proyecto.subscription_service.domain.model.Subscription;


public interface SubscriptionRepositoryPort {
  Subscription save(Subscription subscription);
  Optional<Subscription> findById(UUID id);
}
