package com.proyecto.subscription_service.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.subscription_service.infrastructure.adapter.out.persistence.entity.SubscriptionEntity;

@Repository
public interface SpringDataSubscriptionRepository extends MongoRepository<SubscriptionEntity, String>{

}
