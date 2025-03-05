package com.gestionprofesseurs.gestion_professeurs.controllers;

import com.gestionprofesseurs.gestion_professeurs.models.Professeur;
import com.gestionprofesseurs.gestion_professeurs.services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {
    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    @GetMapping("/{id}")
    public Optional<Professeur> getProfesseurById(@PathVariable Long id) {
        return professeurService.getProfesseurById(id);
    }

    @PostMapping
    public Professeur ajouterProfesseur(@RequestBody Professeur professeur) {
        return professeurService.ajouterProfesseur(professeur);
    }

    @DeleteMapping("/{id}")
    public void supprimerProfesseur(@PathVariable Long id) {
        professeurService.supprimerProfesseur(id);
}
}