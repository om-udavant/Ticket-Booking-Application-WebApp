package com.infotech.TicketBooking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingAppDao extends CrudRepository<Tickets, Integer>{



}
