package com.spring_project.Ticket_booking_webApp.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_project.Ticket_booking_webApp.Dao.BusDao;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Component
@Data
public class BusScheduleDto {
	private int id;
	private LocalDate date;
	private String sourcecity;
	private String destinationcity;
	private int distance;
	private int fare;
	private LocalTime departtime;
	private LocalTime arrivaltime;
	private SeatDto [] seat;
	private BusDto bus;	
}
