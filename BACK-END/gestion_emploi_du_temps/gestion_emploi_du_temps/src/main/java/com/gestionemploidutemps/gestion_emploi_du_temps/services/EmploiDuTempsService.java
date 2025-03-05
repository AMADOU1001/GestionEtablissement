package com.gestionemploidutemps.gestion_emploi_du_temps.services;

import com.gestionemploidutemps.gestion_emploi_du_temps.models.EmploiDuTemps;
import com.gestionemploidutemps.gestion_emploi_du_temps.repositories.EmploiDuTempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploiDuTempsService {
    @Autowired
    private EmploiDuTempsRepository emploiDuTempsRepository;

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
}