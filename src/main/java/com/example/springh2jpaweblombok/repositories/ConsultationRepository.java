package com.example.springh2jpaweblombok.repositories;

import com.example.springh2jpaweblombok.entities.Consultation;
import com.example.springh2jpaweblombok.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

}
