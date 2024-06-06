package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_project.Ticket_booking_webApp.Entity.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer> {

}
