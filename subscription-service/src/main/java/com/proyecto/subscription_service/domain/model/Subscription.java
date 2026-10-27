package com.proyecto.subscription_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Subscription {
  private UUID id;
  private UUID userId;
  private String planId;
  private SubscriptionStatus status;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public Subscription(UUID id, UUID userId, String planId, SubscriptionStatus status, LocalDateTime startDate, LocalDateTime endDate) {
      this.id = id != null ? id : UUID.randomUUID();
      this.userId = userId;
      this.planId = planId;
      this.status = status != null ? status : SubscriptionStatus.PENDING;
      this.startDate = startDate != null ? startDate : LocalDateTime.now();
      this.endDate = endDate;
  }
  // Getters
  public UUID getId() { return id; }
  public UUID getUserId() { return userId; }
  public String getPlanId() { return planId; }
  public SubscriptionStatus getStatus() { return status; }
  public LocalDateTime getStartDate() { return startDate; }
  public LocalDateTime getEndDate() { return endDate; }

  // Reglas de negocio o métodos de alteración de estado si es necesario
  public void cancel() {
    this.status = SubscriptionStatus.CANCELED;
  }
}
