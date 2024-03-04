package com.example.springh2jpaweblombok.service;


import com.example.springh2jpaweblombok.entities.Consultation;
import com.example.springh2jpaweblombok.entities.Medecin;
import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}


