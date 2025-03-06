package com.gestionemploidutemps.gestion_emploi_du_temps.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.gestionemploidutemps.gestion_emploi_du_temps")
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
