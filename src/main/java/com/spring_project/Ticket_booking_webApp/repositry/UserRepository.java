package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring_project.Ticket_booking_webApp.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select a from User a where a.email=?1 AND a.password=?2 ")
	public User userLogin(String email,String password);
}
