package com.kte_labs.test.Services;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.Ticket;
import com.kte_labs.test.Entity.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Transactional
    public Ticket saveAndFlushTicket(TimeSlot timeSlot){
        Ticket ticket = new Ticket(timeSlot);
        Ticket response = ticketRepository.saveAndFlush(ticket);
        return response;
    }
    @Transactional(readOnly = true)
    public Ticket getTicket(int id){
        Optional<Ticket> ticketResponse = ticketRepository.findById(id);
        Ticket ticket = ticketResponse.get();
        return ticket;
    }
    public boolean addTimeSlotInTicket(TimeSlot timeSlot, @Autowired TicketRepository ticketRepository) {
        List<Ticket> ticketList = ticketRepository.findAll();
        if (ticketList.stream()
                .anyMatch(ticket -> ((ticket.getId_doctor().intValue() == timeSlot.getId_doctor().intValue()) &&
                        ((ticket.getTimeOfReceipt().getTime().getTime() + ticket.getDurationInMinutes() * 60 * 1000) > timeSlot.getTimeOfReceipt().getTime().getTime())))) {
            return false;
        }
        Ticket ticket = new Ticket(timeSlot);
        ticketRepository.saveAndFlush(ticket);
        return true;
    }
}
