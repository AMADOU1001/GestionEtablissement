
package com.gestionetudiant.gestion_etudiant.repositories;

import com.gestionetudiant.gestion_etudiant.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{
        }