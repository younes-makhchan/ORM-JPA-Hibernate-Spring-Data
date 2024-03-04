package com.example.springh2jpaweblombok.repositories;

import com.example.springh2jpaweblombok.entities.Consultation;
import com.example.springh2jpaweblombok.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

}
