package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_project.Ticket_booking_webApp.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
