package com.spring_project.Ticket_booking_webApp.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@Component
public class BusSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private String sourcecity;
	private String destinationcity;
	private int distance;
	private int fare;
	private LocalTime departtime;
	private LocalTime arrivaltime;
	@OneToMany (cascade = CascadeType.ALL)
	private Seat [] seat;
	@ManyToOne
	@JsonIgnore	
	private Bus bus;	
}
