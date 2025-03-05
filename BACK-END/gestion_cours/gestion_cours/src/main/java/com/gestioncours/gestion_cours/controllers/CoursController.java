package com.gestioncours.gestion_cours.controllers;

import com.gestioncours.gestion_cours.models.Cours;
import com.gestioncours.gestion_cours.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.gestioncours.gestion_cours.clients.EtudiantClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cours")
public class CoursController {
    @Autowired
    private CoursService coursService;

    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public Optional<Cours> getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }

    @PostMapping
    public Cours ajouterCours(@RequestBody Cours cours) {
        return coursService.ajouterCours(cours);
    }

    @DeleteMapping("/{id}")
    public void supprimerCours(@PathVariable Long id) {
        coursService.supprimerCours(id);
}

    @Autowired
    private EtudiantClient etudiantClient;

    @GetMapping("/etudiants")
    public List<Map<String, Object>> getEtudiants() {
        return etudiantClient.getAllEtudiants();
    }
}