package com.proyecto.subscription_service.infrastructure.adapter.out.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.proyecto.subscription_service.application.port.out.SubscriptionRepositoryPort;
import com.proyecto.subscription_service.domain.model.Subscription;
import com.proyecto.subscription_service.infrastructure.adapter.out.mapper.SubscriptionPersistenceMapper;
import com.proyecto.subscription_service.infrastructure.adapter.out.persistence.entity.SubscriptionEntity;
import com.proyecto.subscription_service.infrastructure.adapter.out.persistence.repository.SpringDataSubscriptionRepository;

@Component
public class SubscriptionPersistenceAdapter implements SubscriptionRepositoryPort {

  private final SpringDataSubscriptionRepository repository;
  private final SubscriptionPersistenceMapper mapper;

  public SubscriptionPersistenceAdapter(SpringDataSubscriptionRepository repository, SubscriptionPersistenceMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Subscription save(Subscription subscription) {
    SubscriptionEntity entity = mapper.toEntity(subscription);
    SubscriptionEntity saved = repository.save(entity);
    return mapper.toDomain(saved);
  }

  @Override
  public Optional<Subscription> findById(UUID id) {
    return repository.findById(id.toString()).map(mapper::toDomain);
  }


}
