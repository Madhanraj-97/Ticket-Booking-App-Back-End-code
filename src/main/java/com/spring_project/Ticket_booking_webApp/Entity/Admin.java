package com.spring_project.Ticket_booking_webApp.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@Component
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String operator;
	private String email;
	private String password;
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bus> bus;
		
	
}
