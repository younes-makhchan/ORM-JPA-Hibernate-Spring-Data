package com.example.springh2jpaweblombok.web;


import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

 @Autowired
    private PatientRepository patientRepository;
 @GetMapping("/patients")
    private List<Patient> getPatients(){
     return patientRepository.findAll();
    }
}
