package com.proyecto.subscription_service.infrastructure.adapter.in.rest;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.proyecto.subscription_service.application.port.out.UserValidationPort;

@Component
public class UserWebClientAdapter implements UserValidationPort{

  private static final Logger log = LoggerFactory.getLogger(UserWebClientAdapter.class);
  private final WebClient webClient;

  public UserWebClientAdapter(WebClient userWebClient) {
    this.webClient = userWebClient;
  }

  @Override
    public boolean existsUser(UUID userId) {
      log.info("🔍 [WEBCLIENT] Consultando existencia del usuario con ID: {} al user-service...", userId);
        try {
            webClient.get()
                  .uri("/api/v1/users/{id}", userId)
                  .retrieve()
                  .bodyToMono(Void.class)
                  .block(); // Bloqueo controlado para entorno imperativo
            log.info("✅ [WEBCLIENT] ¡Usuario con ID: {} encontrado exitosamente!", userId);
            return true; // El usuario existe (200 OK)
        } catch (WebClientResponseException.NotFound e) {
            log.warn("⚠️ [WEBCLIENT] El usuario con ID: {} no existe en el user-service (404 Not Found)", userId);
            return false; // El usuario no existe (404 Not Found)
        } catch (Exception e) {
            log.error("❌ [WEBCLIENT] Error crítico al conectar con el user-service: {}", e.getMessage());
            throw new RuntimeException("Error de comunicación con el user-service", e);
        }
    }


}
