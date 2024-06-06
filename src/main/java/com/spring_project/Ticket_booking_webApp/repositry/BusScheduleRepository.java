package com.spring_project.Ticket_booking_webApp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Integer> {

}
