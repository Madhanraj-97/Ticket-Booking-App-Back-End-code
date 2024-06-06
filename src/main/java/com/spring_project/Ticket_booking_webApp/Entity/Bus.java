package com.spring_project.Ticket_booking_webApp.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Component
@Data
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String busno;
	private int seatcapacity;
	private String operator;
	private String ac;
	@OneToOne(cascade = CascadeType.ALL)
	private BusSchedule schedule;
	@OneToMany (cascade = CascadeType.ALL)
	private Seat [] seat;
	@ManyToOne
	@JsonIgnore
	private Admin admin;
	
}
