package com.example.FinalProjectLogbook;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.FinalProjectLogbook.model.Flight;
import com.example.FinalProjectLogbook.model.FlightRepository;
import com.example.FinalProjectLogbook.model.Aircraft;
import com.example.FinalProjectLogbook.model.AircraftRepository;
import com.example.FinalProjectLogbook.model.User;
import com.example.FinalProjectLogbook.model.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
		
		@Autowired
		private FlightRepository repository;
		
		@Autowired
		private AircraftRepository crepo;
		
		@Autowired
		private UserRepository urepo;
		
		@Test
		public void findByTitleShouldReturnBook() {
			List<Flight> flights = repository.findByPic("Self");
			assertThat(flights).hasSize(1);
			assertThat(flights.get(0).getDate()).isEqualTo("Test Date");
		}
		
		@Test
		public void findByNameShouldReturnCategory() {
			List<Aircraft> aircrafts = crepo.findByName("OY-JZM");
			assertThat(aircrafts).hasSize(1);
			assertThat(aircrafts.get(0).getName()).isEqualTo("OY-JZM");
		}
		
		@Test
		public void findByUsernameShouldReturnUser() {
			User user = urepo.findByUsername("user");
			List<User> users = new ArrayList<>();
			users.add(user);
			assertThat(users).hasSize(1);
			assertThat(users.get(0).getUsername()).isEqualTo("user");
		}
		
		@Test
		public void createNewBookTest() {
			Flight flight = new Flight(LocalDate.of(2021, 7, 22), "ENGM", LocalTime.of(13,22), "EFVA", LocalTime.of(17,12), LocalTime.of(17,12), 1, "Self", "Training flight", crepo.findByName("OY-JZM").get(0));
			repository.save(flight);
			assertThat(flight.getId()).isNotNull();
		}
		
		@Test
		public void createNewCategoryTest() {
			Aircraft aircraft = new Aircraft("TestCat");
			crepo.save(aircraft);
			assertThat(aircraft.getAircraftid()).isNotNull();
		}
		
		@Test
		public void createNewUserTest() {
			User user2 = new User("user", "$2a$04$d2VDhQv3tLUBiR6Zp.pfOORsLeR/Qqqpk/bknRuPHKMUGsA1sGC3O", "USER", "");
			urepo.save(user2);
			assertThat(user2.getId()).isNotNull();
		}
		
		@Test
		public void deleteBookTest() {
			List<Flight> flights = repository.findByPic("TestPic");
			repository.deleteById(flights.get(0).getId());
			List<Flight> flight = repository.findByPic("TestPic");
			assertThat(flight).hasSize(0);
		}
		
		@Test
		public void deleteAircraftTest() {
			List<Aircraft> aircrafts = crepo.findByName("OY-JZN");
			crepo.deleteById(aircrafts.get(0).getAircraftid());
			List<Aircraft> aircraft = crepo.findByName("OY-JZN");
			assertThat(aircraft).hasSize(0);
		}
		
		@Test
		public void deleteUserTest() {
			User user = urepo.findByUsername("user");
			urepo.deleteById(user.getId());
			List<User> users = new ArrayList<>();
			users.add(urepo.findByUsername("user"));
			assertThat(users.get(0)).isNull();
		}

}
