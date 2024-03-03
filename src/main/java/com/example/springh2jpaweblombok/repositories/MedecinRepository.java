package com.example.springh2jpaweblombok.repositories;

import com.example.springh2jpaweblombok.entities.Medecin;
import com.example.springh2jpaweblombok.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Integer> {

}
