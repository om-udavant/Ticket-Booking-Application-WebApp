package com.infotech.TicketBooking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {
	
	Return Hello;
	@Autowired
	private TicketBookingServices ticketBookingServices;

	@PostMapping(value="/create")
	public Tickets createTicket(@RequestBody Tickets ticket){
		return ticketBookingServices.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	//@RequestMapping(value="/ticket/{ticketId}")
	public Optional<Tickets> getTicketById(@PathVariable("ticketId")Integer ticketId){
		return ticketBookingServices.getTicketById(ticketId);
	}
	@GetMapping(value="/ticket/alltickets")
	public Iterable<Tickets> getAllBookedTickets(){
		return ticketBookingServices.getAllBookedTickets();
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
		ticketBookingServices.deleteTicket(ticketId);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public Tickets updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
		return ticketBookingServices.updateTicket(ticketId,newEmail);
	}

}
