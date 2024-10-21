package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.AdminDto;
import com.spring_project.Ticket_booking_webApp.Dto.BusDto;
import com.spring_project.Ticket_booking_webApp.Entity.Admin;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.repositry.AdminRepository;
import com.spring_project.Ticket_booking_webApp.repositry.BusRepository;
import com.spring_project.Ticket_booking_webApp.service.AdminSerice;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Repository
public class BusDao {
	@Autowired
	BusRepository repo;
	
	public Bus saveBus(Bus bus,int AdminId) {
		bus.setSeat(seats(bus.getSeatcapacity(), bus));
		return repo.save(bus); //this is line save the bus without admin object 

	}
	
	public Seat[] seats(int count,Bus bus) {
		Seat[] seat=new Seat[count];
		for(int i=0;i<count;i++) {
			Seat s=new Seat();
			s.setBus(bus);
			s.setAvilable(false);
			s.setSeatNo(i+1);
			seat[i]=s;
		}
		return seat;
	}

	public Bus findById(int id) {
		Optional<Bus> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}
	
	public Bus findByBusNo(String Busno) {
		Optional<Bus> optional=repo.findByBusNo(Busno);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	public Bus deleteBus(int id) {
		Bus bus = findById(id);
		if (bus != null) {
			repo.delete(bus);
			return bus;
		}
		return bus;
	}

	public Bus updateBus(Bus bus, int id) {
		Bus existBus = findById(id);
		if (existBus != null) {
			bus.setId(id);
			return repo.save(bus);
		}
		return null;
	}

	public BusDto busDtoConversion(Bus bus) {
		BusDto busDto = new BusDto();
		busDto.setAc(bus.getAc());
		busDto.setBusno(bus.getBusno());
		busDto.setOperator(bus.getOperator());
		busDto.setSchedule(bus.getSchedule());
		busDto.setSeat(bus.getSeat());
		busDto.setSeatcapacity(bus.getSeatcapacity());
		return busDto;
	}

	public List<Bus> getAllBus() {
		return repo.findAll();
	}

}
