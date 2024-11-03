package com.spring_project.Ticket_booking_webApp.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spring_project.Ticket_booking_webApp.Entity.Bus;

public interface BusRepository extends JpaRepository<Bus,Integer> {
	@Query("select a from Bus a where a.busno=?1 ")
	public <T> Optional<T> findByBusNo(String busno);
	
	@Transactional
	@Modifying
	@Query("update Bus b SET b.admin = NULL WHERE b.id =?1")
	int removeAdminFromBus(int id);
	
	@Transactional
	@Modifying
	@Query("update Bus b SET b.seat = NULL WHERE b.id =?1")
	int removeSeatsFromBus(int id);
	
	
}
