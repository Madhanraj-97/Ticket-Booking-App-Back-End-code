package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.PassengerDto;
import com.spring_project.Ticket_booking_webApp.Entity.Passenger;
import com.spring_project.Ticket_booking_webApp.repositry.PassengerRepository;

@Repository
public class PassengerDao {
	
	@Autowired
	PassengerRepository repo;
	
	public Passenger savePassenger(Passenger passenger) {
		return repo.save(passenger);
	}

	public Passenger findById(int id) {
		Optional<Passenger> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Passenger deletePassenger(int id) {
		Passenger existPassenger = findById(id);
		if (existPassenger != null) {
			repo.delete(existPassenger);
			return existPassenger;
		} else {
			return null;
		}
	}

	public Passenger updatePassenger(int id, Passenger passenger) {
		Passenger existPassenger = findById(id);
		if (existPassenger != null) {
			passenger.setId(id);
			return repo.save(passenger);
		} else {
			return null;
		}
	}
	public List<Passenger> getAllPassenger(){
		return repo.findAll();
	}
	public PassengerDto passengerDtoConversion(Passenger p) {
		PassengerDto dto=new PassengerDto();
		dto.setAge(p.getAge());
		dto.setName(p.getName());
		dto.setBus(p.getBus());
		dto.setPhoneNo(p.getPhoneNo());
		dto.setSeat(p.getSeat());
		return dto;
	}
	

}
