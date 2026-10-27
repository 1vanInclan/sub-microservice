package com.proyecto.subscription_service.infrastructure.adapter.out.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.proyecto.subscription_service.domain.model.Subscription;
import com.proyecto.subscription_service.infrastructure.adapter.out.persistence.entity.SubscriptionEntity;

@Component
public class SubscriptionPersistenceMapper {
  public SubscriptionEntity toEntity(Subscription domain) {
        return new SubscriptionEntity(
            domain.getId().toString(),
            domain.getUserId(),
            domain.getPlanId(),
            domain.getStatus(),
            domain.getStartDate(),
            domain.getEndDate()
        );
    }

  public Subscription toDomain(SubscriptionEntity entity) {
    return new Subscription(
            UUID.fromString(entity.getId()),
            entity.getUserId(),
            entity.getPlanId(),
            entity.getStatus(),
            entity.getStartDate(),
            entity.getEndDate()
        );
    }
}
