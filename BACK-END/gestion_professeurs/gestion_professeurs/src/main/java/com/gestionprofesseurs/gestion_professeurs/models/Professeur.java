package com.gestionprofesseurs.gestion_professeurs.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professeurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String specialite;
}