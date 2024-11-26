package com.spring_project.Ticket_booking_webApp.Entity;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Component
@Data
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seatNo;
	private boolean status;
	@OneToOne(cascade =CascadeType.ALL )
	private Ticket ticket;
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	@ManyToOne
	private BusSchedule schedule;
	
}
