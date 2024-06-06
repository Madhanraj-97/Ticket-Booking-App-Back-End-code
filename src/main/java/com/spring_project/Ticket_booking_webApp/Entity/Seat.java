package com.spring_project.Ticket_booking_webApp.Entity;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity
@Component
@Data
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seatNo;
	private boolean avilable;
	@OneToOne
	private Passenger passenger;
	@JsonIgnore
	@ManyToOne
	private Bus bus;
}
