package com.gestionemploidutemps.gestion_emploi_du_temps.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ProfesseursClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String etudiantsServiceUrl = "http://localhost:8082/api/professeurs";

    public List<Map<String, Object>> getAllProfesseurs() {
        return restTemplate.getForObject(etudiantsServiceUrl, List.class);
}
}