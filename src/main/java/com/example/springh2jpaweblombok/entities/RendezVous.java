package com.example.springh2jpaweblombok.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date date;
    private  StatusRDV status;

    //patiend should be the join column
    @ManyToOne
    @JoinColumn
    private  Patient patient;
    @ManyToOne
    @JoinColumn
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
