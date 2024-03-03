package com.example.springh2jpaweblombok;

import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

public class SpringH2JpaWebLombokApplicationOld implements CommandLineRunner {
	private   PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringH2JpaWebLombokApplicationOld.class, args);

	}
	public  void run(String ...args)throws Exception{

//		patientRepository.save(new Patient(null,"ahmed", LocalDateTime.now(),false,15));
//		patientRepository.save(new Patient(null,"ilias", LocalDateTime.now(),false,20));
//		patientRepository.save(new Patient(null,"adham", LocalDateTime.now(),false,28));
//
//		patientRepository.save(new Patient(null,"lyazin", LocalDateTime.now(),false,34));

		List<Patient> patientList=patientRepository.findAll();
		for (Patient patient : patientList) {
			System.out.println(patient);
		}
		Patient patientOne = patientRepository.findById(2).orElse(null);
		System.out.println("************************");
		System.out.println(patientOne.getId());
		System.out.println(patientOne.getNom());
		System.out.println(patientOne.getDateNaissance());
		System.out.println(patientOne.getScore());
		System.out.println(patientOne.isMaladie());
		System.out.println("************************");
		List<Patient> selectedPatients = patientRepository.findAllByNomContaining("a");
		System.out.println("Selected Patients who have in their name 'a' ");
		for (Patient selectedPatient : selectedPatients) {
			System.out.println(selectedPatient.getId());
			System.out.println(selectedPatient.getNom());
			System.out.println(selectedPatient.getDateNaissance());
			System.out.println(selectedPatient.getScore());
			System.out.println(selectedPatient.isMaladie());
			System.out.println("************************");

		}
		System.out.println("updating a patient");
		patientOne.setNom("hicham");
		patientRepository.save(patientOne);
		System.out.println("finally deleting the patient");
		patientRepository.delete(patientOne);
	}

}
