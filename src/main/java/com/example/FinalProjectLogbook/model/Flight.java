package com.example.FinalProjectLogbook.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String dep;
	private LocalTime deptime;
	private String dest;
	private LocalTime arrtime;
	private LocalTime duration;
	private int landings;
	private String pic;
	private String comments;


	@ManyToOne
	@JoinColumn(name = "aircraftid")
	private Aircraft aircraft;

	
	public Flight() {
	}

	public Flight(LocalDate date, String dep, LocalTime deptime, String dest, LocalTime arrtime, LocalTime duration, int landings, String pic, String comments, Aircraft aircraft) {
		super();
		this.date = date;
		this.dep = dep;
		this.deptime = deptime;
		this.dest = dest;
		this.arrtime=arrtime;
		this.duration=duration;
		this.landings = landings;
		this.pic = pic;
		this.comments = comments;
		this.aircraft = aircraft;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getDeptime() {
		return deptime;
	}

	public void setDeptime(LocalTime deptime) {
		this.deptime = deptime;
	}

	public LocalTime getArrtime() {
		return arrtime;
	}

	public void setArrtime(LocalTime arrtime) {
		this.arrtime = arrtime;
	}
	
	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getLandings() {
		return landings;
	}

	public void setLandings(int landings) {
		this.landings = landings;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	@Override
	public String toString() {
		if (this.aircraft != null)
			return "Aircraft [id=" + id + ", date=" + date + ", dep=" + dep + ", deptime=" + deptime + ", dest=" + dest + ",arrtime=" + arrtime + ",duration=" + duration + ", landings="
					+ landings + ", pic=" + pic + ", comments=" + comments + " aircraft =" + this.getAircraft() + "]";
		else
			return "Aircraft [id=" + id + ", date=" + date + ", dep=" + dep + ", deptime=" + deptime + ", dest=" + dest + ",arrtime=" + arrtime + ",duration=" + duration + ", landings="
			+ landings + ", pic=" + pic + ", comments=" + comments + "]";
	}

	

}