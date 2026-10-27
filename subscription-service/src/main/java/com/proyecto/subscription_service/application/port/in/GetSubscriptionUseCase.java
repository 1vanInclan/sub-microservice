package com.proyecto.subscription_service.application.port.in;

import java.util.UUID;

import com.proyecto.subscription_service.domain.model.Subscription;


public interface GetSubscriptionUseCase {

  Subscription getSubscriptionById(UUID id);

}
