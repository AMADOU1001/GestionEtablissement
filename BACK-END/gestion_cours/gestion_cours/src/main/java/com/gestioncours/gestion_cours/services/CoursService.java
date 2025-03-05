package com.gestioncours.gestion_cours.services;

import com.gestioncours.gestion_cours.models.Cours;
import com.gestioncours.gestion_cours.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Optional<Cours> getCoursById(Long id) {
        return coursRepository.findById(id);
    }

    public Cours ajouterCours(Cours cours) {
        return coursRepository.save(cours);
    }

    public void supprimerCours(Long id) {
        coursRepository.deleteById(id);
}
}