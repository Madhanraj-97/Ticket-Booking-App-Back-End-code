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

//	public int deleteSeats(int id) {
//		return repo.removeSeatsFromBus(id);
//	}
	public Bus saveBus(Bus bus) {
		return repo.save(bus); // this is line save the bus with admin object
	}


	public Bus findById(int id) {
		Optional<Bus> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public Bus findByBusNo(String Busno) {
		Optional<Bus> optional = repo.findByBusNo(Busno);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Bus deleteBus(int id) {
		Bus bus = findById(id);
		if (bus != null) {
			repo.deleteById(id);
			return bus;
		}
		return bus;
	}

	public Bus updateBus(Bus bus) {
		
		return repo.save(bus);
	}

	public BusDto busDtoConversion(Bus bus) {
		BusDto busDto = new BusDto();
		busDto.setAc(bus.getAc());
		busDto.setBusno(bus.getBusno());
		busDto.setOperator(bus.getOperator());
		busDto.setSeatcapacity(bus.getSeatcapacity());
		busDto.setSeattype(bus.getSeattype());
		return busDto;
	}

	public List<Bus> getAllBus() {
		return repo.findAll();
	}

	public List<Bus> busList(String source, String destination) {
		Optional<List<Bus>> optional= null;
		return optional.isPresent()? optional.get():null;
	}

}
