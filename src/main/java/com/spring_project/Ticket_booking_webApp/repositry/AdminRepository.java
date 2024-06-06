package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring_project.Ticket_booking_webApp.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>  {
	@Query("select a from Admin a where a.email=?1 AND a.password=?2 ")
	public Admin findByEmailAndPassword(String email,String password);
	
}
