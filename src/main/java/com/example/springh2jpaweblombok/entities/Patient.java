package com.example.springh2jpaweblombok.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean maladie;
    private int score;

    //the strong one have mapped
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVousList;
}
