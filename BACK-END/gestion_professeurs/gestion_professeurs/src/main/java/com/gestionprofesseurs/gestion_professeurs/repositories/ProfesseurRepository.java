package com.gestionprofesseurs.gestion_professeurs.repositories;

import com.gestionprofesseurs.gestion_professeurs.models.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long>{
        }