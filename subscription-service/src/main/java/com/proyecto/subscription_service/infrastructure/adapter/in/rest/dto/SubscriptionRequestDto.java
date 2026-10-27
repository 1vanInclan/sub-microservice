package com.proyecto.subscription_service.infrastructure.adapter.in.rest.dto;

import java.util.UUID;

public record SubscriptionRequestDto(
  UUID userId,
  String planId
) {}
