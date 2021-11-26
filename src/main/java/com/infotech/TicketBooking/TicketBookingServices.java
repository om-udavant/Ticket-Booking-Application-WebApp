package com.infotech.TicketBooking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TicketBookingServices {

    @Autowired
    private TicketBookingAppDao ticketBookingAppDao;


    public Tickets createTicket(Tickets tickets) {
        if (tickets.getTicketId() != null && ticketBookingAppDao.existsById(tickets.getTicketId())) {
            throw new RuntimeException("Ticket ID already exists, can't insert ");
        }
        return ticketBookingAppDao.save(tickets);
    }

    public Optional<Tickets> getTicketById(Integer ticketId) {
        return ticketBookingAppDao.findById(ticketId);
    }

    public Iterable<Tickets> getAllBookedTickets() {
        return ticketBookingAppDao.findAll();
    }

    public void deleteTicket(Integer ticketId) {

        ticketBookingAppDao.deleteById(ticketId);
    }

    public Tickets updateTicket(Integer ticketId, String newEmail) {
        Optional<Tickets> ticketFromDb = ticketBookingAppDao.findById(ticketId);
        // if ticket not exists
        // throw runtime
        if(ticketFromDb.isEmpty()){
            throw new RuntimeException("Ticket not found");
        }

        // exists
        // then set new Email on the given ID
        ticketFromDb.get().setEmail(newEmail);

        return ticketBookingAppDao.save(ticketFromDb.get());
    }
}

