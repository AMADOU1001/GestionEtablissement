package com.gestioncours.gestion_cours.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private int nombreHeures;
}