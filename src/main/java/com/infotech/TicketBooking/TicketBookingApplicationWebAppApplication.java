package com.infotech.TicketBooking;


import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class TicketBookingApplicationWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(TicketBookingApplicationWebAppApplication.class, args);
		
		TicketBookingServices ticketBookingServices = applicationContext.getBean("ticketBookingServices", TicketBookingServices.class);
		Tickets ticket = new Tickets();
		ticket.setBookingDate("99/99/99");
		ticket.setDestStation("Mumbai");
		ticket.setSourceStation("Pune");
		ticket.setPassangerName("Om");
		ticket.setEmail("om@gmail.com");
		
		ticketBookingServices.createTicket(ticket);
	}

}
