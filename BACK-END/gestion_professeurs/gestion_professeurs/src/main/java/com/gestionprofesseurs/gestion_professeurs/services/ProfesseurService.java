package com.gestionprofesseurs.gestion_professeurs.services;

import com.gestionprofesseurs.gestion_professeurs.models.Professeur;
import com.gestionprofesseurs.gestion_professeurs.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Optional<Professeur> getProfesseurById(Long id) {
        return professeurRepository.findById(id);
    }

    public Professeur ajouterProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public void supprimerProfesseur(Long id) {
        professeurRepository.deleteById(id);
}
}