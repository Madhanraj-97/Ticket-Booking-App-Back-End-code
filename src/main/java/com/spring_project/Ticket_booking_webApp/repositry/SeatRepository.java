package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring_project.Ticket_booking_webApp.Entity.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
	@Transactional
	@Modifying
	@Query("delete from Seat s where s.bus.id IS NULL")
	int deleteSeats();
	
	@Transactional
	@Modifying
	@Query("update Seat s SET s.bus.id =NULL WHERE s.bus.id =?1")
	int removeBusFromSeats(int id);

	
	


}
