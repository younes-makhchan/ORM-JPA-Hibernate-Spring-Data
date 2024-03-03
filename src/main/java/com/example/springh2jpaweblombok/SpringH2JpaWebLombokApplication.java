package com.example.springh2jpaweblombok;

import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringH2JpaWebLombokApplication implements CommandLineRunner {
	@Autowired
	private   PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringH2JpaWebLombokApplication.class, args);

	}
	@Override
	public  void run(String ...args)throws Exception{

		patientRepository.save(new Patient(null,"ahmed", LocalDateTime.now(),false,15));
		patientRepository.save(new Patient(null,"ilias", LocalDateTime.now(),false,20));
		patientRepository.save(new Patient(null,"adham", LocalDateTime.now(),false,28));

		patientRepository.save(new Patient(null,"lyazin", LocalDateTime.now(),false,34));

		List<Patient> patientList=patientRepository.findAll();
		for (Patient patient : patientList) {
			System.out.println(patient);
		}

	}

}
