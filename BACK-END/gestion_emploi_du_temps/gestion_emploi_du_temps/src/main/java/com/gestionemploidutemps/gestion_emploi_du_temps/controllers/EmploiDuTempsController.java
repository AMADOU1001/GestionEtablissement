package com.gestionemploidutemps.gestion_emploi_du_temps.controllers;

import com.gestionemploidutemps.gestion_emploi_du_temps.models.EmploiDuTemps;
import com.gestionemploidutemps.gestion_emploi_du_temps.services.EmploiDuTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emplois")
public class EmploiDuTempsController {
    @Autowired
    private EmploiDuTempsService emploiDuTempsService;

    @GetMapping
    public List<EmploiDuTemps> getAllEmplois() {
        return emploiDuTempsService.getAllEmplois();
    }

    @GetMapping("/{id}")
    public Optional<EmploiDuTemps> getEmploiById(@PathVariable Long id) {
        return emploiDuTempsService.getEmploiById(id);
    }

    @PostMapping
    public EmploiDuTemps ajouterEmploi(@RequestBody EmploiDuTemps emploi) {
        return emploiDuTempsService.ajouterEmploi(emploi);
    }

    @DeleteMapping("/{id}")
    public void supprimerEmploi(@PathVariable Long id) {
        emploiDuTempsService.supprimerEmploi(id);
}
}