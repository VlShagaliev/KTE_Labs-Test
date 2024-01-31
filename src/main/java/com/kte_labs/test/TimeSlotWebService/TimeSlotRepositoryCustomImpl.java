package com.kte_labs.test.TimeSlotWebService;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.Ticket;
import com.kte_labs.test.Entity.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly = true)
public class TimeSlotRepositoryCustomImpl implements TimeSlotRepositoryCustom{

    @Override
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
