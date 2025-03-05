package com.gestioncours.gestion_cours.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EtudiantClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String etudiantsServiceUrl = "http://localhost:8081/api/etudiants";

    public List<Map<String, Object>> getAllEtudiants() {
        return restTemplate.getForObject(etudiantsServiceUrl, List.class);
}
}