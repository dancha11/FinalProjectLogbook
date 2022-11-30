package com.example.FinalProjectLogbook;

import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.FinalProjectLogbook.model.Flight;
import com.example.FinalProjectLogbook.model.Aircraft;
import com.example.FinalProjectLogbook.model.AircraftRepository;
import com.example.FinalProjectLogbook.model.User;
import com.example.FinalProjectLogbook.model.UserRepository;
import com.example.FinalProjectLogbook.model.FlightRepository;

@SpringBootApplication
public class FinalProjectLogbookApplication {
	private static final Logger log = LoggerFactory.getLogger(FinalProjectLogbookApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(FinalProjectLogbookApplication.class, args);
	}

	@Bean
	public CommandLineRunner flightDemo(FlightRepository repository, AircraftRepository crepo, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of flights");
			//Adding different aircraft registrations
			crepo.save(new Aircraft("OY-JZM"));
			crepo.save(new Aircraft("OY-JZN"));
			crepo.save(new Aircraft("OY-JTP"));
			
			//adding a few flights
			repository.save(new Flight(LocalDate.of(2021, 7, 12), "EFHK", LocalTime.of(13,12), "EFVA", LocalTime.of(14,12), LocalTime.of(01,00), 1, "Self", "Training flight", crepo.findByName("OY-JZM").get(0)));
			repository.save(new Flight(LocalDate.of(2021, 7, 13), "EFVA", LocalTime.of(10,00), "EKCH", LocalTime.of(12,00), LocalTime.of(02,00), 2, "Self", "Ferry flight", crepo.findByName("OY-JZN").get(0)));

			//adding a admin user, password is adminpassword
			User admin = new User("admin", "$2a$04$eC7eQbfku.zj8ST9lkuZEubrnGi7iYtrU3s.mrO.xwpBY3Ym5om.W", "ADMIN", "");
			urepository.save(admin);
			
			//adding a test user, password is password
			User user1 = new User("user", "$2a$04$d2VDhQv3tLUBiR6Zp.pfOORsLeR/Qqqpk/bknRuPHKMUGsA1sGC3O", "USER", "");
			urepository.save(user1);

			
			log.info("fetch all flights");
			for (Flight flight : repository.findAll()) {
				log.info(flight.toString());
			}
		};
	}

}