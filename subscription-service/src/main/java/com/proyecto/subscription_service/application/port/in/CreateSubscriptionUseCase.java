package com.proyecto.subscription_service.application.port.in;

import java.util.UUID;

import com.proyecto.subscription_service.domain.model.Subscription;



public interface CreateSubscriptionUseCase {

  Subscription createSubscription(UUID userId, String planId);

}
