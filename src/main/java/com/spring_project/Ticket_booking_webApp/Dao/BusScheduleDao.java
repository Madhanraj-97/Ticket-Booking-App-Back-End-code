package com.spring_project.Ticket_booking_webApp.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.repositry.BusScheduleRepository;

@Repository
public class BusScheduleDao {
	
	@Autowired
	BusScheduleRepository repo;
	
	public BusSchedule saveSchedule(BusSchedule schedule) {
		return repo.save(schedule);

	}
	
	public Seat[] seats(int count,BusSchedule schedule) {
		Seat[] seat = new Seat[count];
		for (int i = 0; i < count; i++) {
			Seat s = new Seat();
			s.setSeatNo(i + 1);
			s.setSchedule(schedule);
			seat[i] = s;
		}
		return seat;
	}

	public BusSchedule findById(int id) {
		Optional<BusSchedule> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}
	public BusSchedule deleteSchedule(int id) {
		BusSchedule schedule= findById(id);
		if (schedule != null) {
			repo.delete(schedule);
			return schedule;
		}
		return null;
	}
	
	public BusSchedule updateSchedule(BusSchedule schedule, int id) {
		BusSchedule existSchedule = findById(id);
		if (existSchedule != null) {
			schedule.setId(id);
			return repo.save(schedule);
		}
		return null;
	}

	public BusScheduleDto scheduleDtoConversion(BusSchedule schedule) {
		BusScheduleDto dto=new BusScheduleDto();
		dto.setArrivaltime(schedule.getArrivaltime());
		dto.setDate(schedule.getDate());
		dto.setDeparttime(schedule.getDeparttime());
		dto.setDestinationcity(schedule.getDestinationcity());
		dto.setDistance(schedule.getDistance());
		dto.setFare(schedule.getFare());
		dto.setId(schedule.getId());
		dto.setSourcecity(schedule.getSourcecity());
		return dto;
	}
	public List<BusSchedule> searchBus(String from,String to, LocalDate date){
		List<BusSchedule> list=repo.searchBus(from, to,date);
		return list;
	}
	
	
	
}
