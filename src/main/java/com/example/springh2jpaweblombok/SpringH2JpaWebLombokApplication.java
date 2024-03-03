package com.example.springh2jpaweblombok;

import com.example.springh2jpaweblombok.entities.Medecin;
import com.example.springh2jpaweblombok.entities.Patient;
import com.example.springh2jpaweblombok.repositories.MedecinRepository;
import com.example.springh2jpaweblombok.repositories.PatientRepository;
import com.example.springh2jpaweblombok.repository.PatientRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringH2JpaWebLombokApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringH2JpaWebLombokApplication.class, args);

	}
	@Bean
	CommandLineRunner start(
			PatientRepository patientRepository,
			MedecinRepository medecinRepository
	){
		return (args)->{

			Stream.of("Mohammed","Hassan","Najat").forEach((String name)->{
				Patient patient=Patient.builder()
						.nom(name)
						.dateNaissance(new Date())
						.maladie(false)
						.score(15)
						.build();
				patientRepository.save(patient);

			});
			Stream.of("anas","linux","wie").forEach((String name)->{
				Medecin medecin=Medecin.builder()
						.nom(name)
						.specialite(Math.random()>.5?"Cardio":"Dentist")
						.email(name+"@gmail.com")
						.build();
				medecinRepository.save(medecin);

			});

		};
	}

}
