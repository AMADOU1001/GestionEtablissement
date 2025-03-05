package com.gestionetablissement.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gestion-etudiants", r -> r.path("/api/etudiants/").uri("http://localhost:8081"))
                .route("gestion-profs", r -> r.path("/api/professeurs/").uri("http://localhost:8082"))
                .route("gestion-cours", r -> r.path("/api/cours/").uri("http://localhost:8083"))
                .route("gestion-classes", r -> r.path("/api/classes/").uri("http://localhost:8084"))
                .route("gestion-emplois", r -> r.path("/api/emplois/").uri("http://localhost:8085"))
                .build();
}
}