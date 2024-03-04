package com.example.springh2jpaweblombok;

import com.example.springh2jpaweblombok.entities.*;
import com.example.springh2jpaweblombok.repositories.MedecinRepository;
import com.example.springh2jpaweblombok.repositories.PatientRepository;
import com.example.springh2jpaweblombok.repositories.RendezVousRepository;
import com.example.springh2jpaweblombok.service.IHospitalService;
import com.example.springh2jpaweblombok.service.UserServiceImpl;
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
			UserServiceImpl userService
	){
		return (args)->{
			Stream.of("user1","admin").forEach(s ->
			{  User u=User.builder()
					.username(s)
					.password("123456")
					.build();
				userService.addNewUser(u);

			});

			Stream.of("STUDENT","USER","ADMIN").forEach(s ->
			{  Role role1=new Role();
				role1.setRolename(s);
				userService.addNewRole(role1);

			});
			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","USER");

			try{
				User user=userService.authenticate("user1","13456");
				System.out.println(user.getUserId());
				System.out.println(user.getUsername());

				user.getRoles().forEach(role -> System.out.println(role.getRolename()));
			}catch (Exception e){
				System.out.println("Bad credentials");
			}

		};
	}

	CommandLineRunner startOld(
			IHospitalService hospitalService,
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
				hospitalService.savePatient(patient);

			});
			Stream.of("anas","linux","wie").forEach((String name)->{
				Medecin medecin=Medecin.builder()
						.nom(name)
						.specialite(Math.random()>.5?"Cardio":"Dentist")
						.email(name+"@gmail.com")
						.build();
				hospitalService.saveMedecin(medecin);

			});
			Patient patient=patientRepository.findAll().get(0);

			Patient patient1=patientRepository.findByNom("Mohammed");

			Medecin medecin=medecinRepository.findByNom("anas");

			RendezVous rendezVous= RendezVous.builder()
					.date(new Date())
					.status(StatusRDV.PENDING)
					.medecin(medecin)
					.patient(patient)
					.build();
			hospitalService.saveRDV(rendezVous);

			Consultation consultation=Consultation.builder()
					.dateConsultation(new Date())
					.rendezVous(rendezVous)
					.rapport("Rapport de la consultation...")
					.build();
			hospitalService.saveConsultation(consultation);


		};
	}

}
