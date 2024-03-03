package com.example.springh2jpaweblombok.repository;

import com.example.springh2jpaweblombok.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepositoryOld extends JpaRepository<Patient,Integer> {

    List<Patient> findAllByNomContaining(String nom);


}
