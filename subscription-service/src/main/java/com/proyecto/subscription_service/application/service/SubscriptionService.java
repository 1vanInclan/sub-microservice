package com.proyecto.subscription_service.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.proyecto.subscription_service.application.port.in.CreateSubscriptionUseCase;
import com.proyecto.subscription_service.application.port.in.GetSubscriptionUseCase;
import com.proyecto.subscription_service.application.port.out.SubscriptionRepositoryPort;
import com.proyecto.subscription_service.application.port.out.UserValidationPort;
import com.proyecto.subscription_service.domain.exception.SubscriptionNotFoundException;
import com.proyecto.subscription_service.domain.model.Subscription;
import com.proyecto.subscription_service.domain.model.SubscriptionStatus;

@Service
public class SubscriptionService implements CreateSubscriptionUseCase, GetSubscriptionUseCase {

  private final SubscriptionRepositoryPort subscriptionRepositoryPort;
  private final UserValidationPort userValidationPort;

  public SubscriptionService(SubscriptionRepositoryPort subscriptionRepositoryPort, UserValidationPort userValidationPort) {
    this.subscriptionRepositoryPort = subscriptionRepositoryPort;
    this.userValidationPort = userValidationPort;
  }

  @Override
    public Subscription createSubscription(UUID userId, String planId) {

        System.out.println("Validate userId");
        boolean userExist = userValidationPort.existsUser(userId);

        System.out.println(userExist);

        if (!userExist) {
          throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }

        System.out.println("Validate success");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endDate = now.plusDays(30);

        Subscription subscription = new Subscription(
                null,
                userId,
                planId,
                SubscriptionStatus.ACTIVE,
                now,
                endDate
        );

        return subscriptionRepositoryPort.save(subscription);
    }

    @Override
    public Subscription getSubscriptionById(UUID id) {
        return subscriptionRepositoryPort.findById(id)
          .orElseThrow(() -> new SubscriptionNotFoundException(id));
    }
}
