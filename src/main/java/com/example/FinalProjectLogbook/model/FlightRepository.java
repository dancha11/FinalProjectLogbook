package com.example.FinalProjectLogbook.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
	List<Flight> findByDate(LocalDate date);

	List<Flight> findByPic(String pic);
}