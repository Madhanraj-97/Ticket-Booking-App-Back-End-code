package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.repositry.BusScheduleRepository;

@Repository
public class BusScheduleDao {
	@Autowired
	BusScheduleRepository repo;
	
	public BusSchedule saveSchedule(BusSchedule schedule) {
		return repo.save(schedule);

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
		dto.setBus(schedule.getBus());
		dto.setDestinationCity(schedule.getDestinationcity());
		dto.setDistance(schedule.getDistance());
		dto.setEstimatedTime(schedule.getEstimatedtime());
		dto.setSourceCity(schedule.getSourcecity());
		return dto;
	}

	
}
