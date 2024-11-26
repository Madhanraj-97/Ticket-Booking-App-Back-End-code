package com.spring_project.Ticket_booking_webApp.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_project.Ticket_booking_webApp.Entity.Admin;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Component
public class BusDto {
	private int id;
	private String busno;
	private int seatcapacity;
	private String operator;
	private String ac;
	private String seattype;
}
 