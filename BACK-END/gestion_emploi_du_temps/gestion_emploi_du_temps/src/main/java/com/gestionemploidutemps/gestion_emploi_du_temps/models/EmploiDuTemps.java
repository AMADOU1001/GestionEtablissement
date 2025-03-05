package com.gestionemploidutemps.gestion_emploi_du_temps.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emplois_du_temps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classe;
    private String professeur;
    private String cours;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}