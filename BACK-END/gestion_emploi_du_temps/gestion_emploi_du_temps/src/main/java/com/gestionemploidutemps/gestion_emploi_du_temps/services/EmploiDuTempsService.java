package com.gestionemploidutemps.gestion_emploi_du_temps.services;

import com.gestionemploidutemps.gestion_emploi_du_temps.models.EmploiDuTemps;
import com.gestionemploidutemps.gestion_emploi_du_temps.repositories.EmploiDuTempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmploiDuTempsService {
    @Autowired
    private EmploiDuTempsRepository emploiDuTempsRepository;

    private final RestTemplate restTemplate;

    @Autowired  // Ajoute cette annotation
    public EmploiDuTempsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EmploiDuTemps> getAllEmplois() {
        return emploiDuTempsRepository.findAll();
    }

    public Optional<EmploiDuTemps> getEmploiById(Long id) {
        return emploiDuTempsRepository.findById(id);
    }

    public EmploiDuTemps ajouterEmploi(EmploiDuTemps emploi) {
        return emploiDuTempsRepository.save(emploi);
    }

    public void supprimerEmploi(Long id) {
        emploiDuTempsRepository.deleteById(id);
    }

public  EmploiDuTemps modifierEmploi(Long id, EmploiDuTemps emploi) {
    Optional<EmploiDuTemps> existingEmploi = emploiDuTempsRepository.findById(id);
    if (existingEmploi.isPresent()) {
        EmploiDuTemps updatedEmploi = existingEmploi.get();
        updatedEmploi.setClasse(emploi.getClasse());
        updatedEmploi.setProfesseur(emploi.getProfesseur());
        updatedEmploi.setCours(emploi.getCours());
        updatedEmploi.setDateDebut(emploi.getDateDebut());
        updatedEmploi.setDateFin(emploi.getDateFin());
        return emploiDuTempsRepository.save(updatedEmploi);
    } else {
        throw new RuntimeException("Emploi du temps non trouvé avec l'ID : " + id);
    }
}
}
