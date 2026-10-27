package com.proyecto.subscription_service.infrastructure.config;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


  @Bean
    public WebClient userWebClient(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        return WebClient.builder()
                .baseUrl("http://user-service") // Nombre lógico registrado en Eureka
                .filter(lbFunction)            // Aplica el balanceo de carga automáticamente
                .build();
    }

}
