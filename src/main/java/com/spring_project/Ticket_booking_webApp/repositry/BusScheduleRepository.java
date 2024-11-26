package com.spring_project.Ticket_booking_webApp.repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Integer> {
	@Query("select b from BusSchedule b where b.sourcecity=?1 AND b.destinationcity=?2 AND b.date=?3")
	public List<BusSchedule> searchBus(String des, String to,LocalDate date);
}
