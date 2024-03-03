package com.example.springh2jpaweblombok.repository;

import com.example.springh2jpaweblombok.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Integer> {




}
