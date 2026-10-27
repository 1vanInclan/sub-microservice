package com.proyecto.subscription_service.infrastructure.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.subscription_service.application.port.in.CreateSubscriptionUseCase;
import com.proyecto.subscription_service.application.port.in.GetSubscriptionUseCase;
import com.proyecto.subscription_service.domain.model.Subscription;
import com.proyecto.subscription_service.infrastructure.adapter.in.rest.dto.SubscriptionRequestDto;
import com.proyecto.subscription_service.infrastructure.adapter.in.rest.dto.SubscriptionResponseDto;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {
  

  private final CreateSubscriptionUseCase createSubscriptionUseCase;
  private final GetSubscriptionUseCase getSubscriptionUseCase;

  public SubscriptionController(CreateSubscriptionUseCase createSubscriptionUseCase, GetSubscriptionUseCase getSubscriptionUseCase) {
    this.createSubscriptionUseCase = createSubscriptionUseCase;
    this.getSubscriptionUseCase = getSubscriptionUseCase;
  }

  @PostMapping
  public ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto requestDto) {
    Subscription subscription = createSubscriptionUseCase.createSubscription(requestDto.userId(), requestDto.planId());
    return ResponseEntity.ok(toResponseDto(subscription));
  }

  @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponseDto> getSubscriptionById(@PathVariable UUID id) {
        Subscription subscription = getSubscriptionUseCase.getSubscriptionById(id);
        return ResponseEntity.ok(toResponseDto(subscription));
    }

  private SubscriptionResponseDto toResponseDto(Subscription subscription) {
        return new SubscriptionResponseDto(
                subscription.getId(),
                subscription.getUserId(),
                subscription.getPlanId(),
                subscription.getStatus(),
                subscription.getStartDate(),
                subscription.getEndDate()
        );
    }
}
