package com.gestionetudiant.gestion_etudiant.controllers;

import com.gestionetudiant.gestion_etudiant.models.Etudiant;
import com.gestionetudiant.gestion_etudiant.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
}
}