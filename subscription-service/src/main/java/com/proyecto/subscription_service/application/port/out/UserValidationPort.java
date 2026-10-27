package com.proyecto.subscription_service.application.port.out;

import java.util.UUID;

public interface UserValidationPort {
  boolean existsUser(UUID userId);
}
