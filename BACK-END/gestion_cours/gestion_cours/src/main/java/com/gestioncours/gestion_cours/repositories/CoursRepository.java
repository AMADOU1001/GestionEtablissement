package com.gestioncours.gestion_cours.repositories;

import com.gestioncours.gestion_cours.models.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours,Long>{
        }