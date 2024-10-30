package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.SeatDto;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.repositry.SeatRepository;

@Repository
public class SeatDao {

	@Autowired
	SeatRepository repo;

	public Seat saveSeat(Seat seat) {
		return repo.save(seat);
	}

	public Seat findById(int id) {
		Optional<Seat> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Seat deleteSeat(int id) {
		Seat existSeat = findById(id);
		if (existSeat != null) {
			repo.delete(existSeat);
			return existSeat;
		} else {
			return null;
		}
	}

	public Seat updateSeat(int id, Seat seat) {
		Seat existSeat = findById(id);
		if (existSeat != null) {
			seat.setId(id);
			return repo.save(seat);
		} else {
			return null;
		}
	}

	public List<Seat> getAllSeat() {
		return repo.findAll();
	}

	// function for delete seats where bus.is is null;
	public int deleteSeats() {
		return repo.deleteSeats();
	}

	public int removeBus(int id) {
		return repo.removeBusFromSeats(id);
	}

	public SeatDto seatDtoConversion(Seat s) {
		SeatDto dto = new SeatDto();
		dto.setBus(s.getBus());
		dto.setPassenger(s.getPassenger());
		dto.setSeatNo(s.getSeatNo());
		return dto;
	}

}
