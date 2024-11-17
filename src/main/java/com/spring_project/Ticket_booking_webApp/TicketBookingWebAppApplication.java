package com.spring_project.Ticket_booking_webApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TicketBookingWebAppApplication {

	public static void main(String[] args) {
		
		System.out.println("${DB_URL}");
		SpringApplication.run(TicketBookingWebAppApplication.class, args);
	}

}
