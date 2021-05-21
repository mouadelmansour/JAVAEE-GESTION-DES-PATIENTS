package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dao.PatientRepositoty;
import com.example.demo.entities.Patient;

@SpringBootApplication
@ComponentScan("springboot")
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private PatientRepositoty patientRepositoty;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		patientRepositoty.save(new Patient(null,"moad", new Date(),100,false));
		patientRepositoty.save(new Patient(null,"moad", new Date(),300,true));
		patientRepositoty.save(new Patient(null,"Naimy", new Date(),600,false));
		patientRepositoty.save(new Patient(null,"hasan", new Date(),900,false));
		patientRepositoty.save(new Patient(null,"moad", new Date(),100,false));
		patientRepositoty.save(new Patient(null,"moad", new Date(),300,true));
		patientRepositoty.save(new Patient(null,"Naimy", new Date(),600,false));
		patientRepositoty.save(new Patient(null,"hasan", new Date(),900,false));
		patientRepositoty.save(new Patient(null,"moad", new Date(),100,false));
		
		patientRepositoty.findAll().forEach(p->{
			System.out.println(p.getNom());
		});
		
	}

}
