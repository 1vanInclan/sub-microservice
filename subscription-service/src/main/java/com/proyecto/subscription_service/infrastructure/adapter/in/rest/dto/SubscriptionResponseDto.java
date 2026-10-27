package com.proyecto.subscription_service.infrastructure.adapter.in.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.proyecto.subscription_service.domain.model.SubscriptionStatus;

public record SubscriptionResponseDto(
  UUID Id,
  UUID userId,
  String planId,
  SubscriptionStatus status,
  LocalDateTime startDate,
  LocalDateTime endDate
) {}
