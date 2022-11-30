package com.example.FinalProjectLogbook.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Aircraft {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aircraftid;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aircraft")
	private List<Flight> flights;

	public Aircraft() {}
	
	public Aircraft(String name) {
		this.name = name;
		this.flights = new ArrayList<>();
	}

	public Long getAircraftid() {
		return aircraftid;
	}

	public void setAircraftid(Long aircraftid) {
		this.aircraftid = aircraftid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	@Override
	public String toString() {
		return "Aircraft [aircraftid=" + aircraftid + ", name=" + name + "]";
	}
}
