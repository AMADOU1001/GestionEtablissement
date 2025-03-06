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

public Professeur modifierProfesseur(Long id, Professeur professeur) {
    Optional<Professeur> existingProf = professeurRepository.findById(id);
    if (existingProf.isPresent()) {
        Professeur updatedProf = existingProf.get();
        updatedProf.setNom(professeur.getNom());
        updatedProf.setPrenom(professeur.getPrenom());
        updatedProf.setSpecialite(professeur.getSpecialite());
        return professeurRepository.save(updatedProf);
    } else {
        throw new RuntimeException("Professeur non trouvé avec l'ID : " + id);
    }
}

}