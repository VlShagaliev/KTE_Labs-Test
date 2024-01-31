package com.kte_labs.test.WebService;

import com.kte_labs.test.RESTService.DBRepository.TicketRepository;
import com.kte_labs.test.RESTService.Entity.Ticket;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Service
public class TimeSlotService {
    @Autowired
    private TicketRepository ticketRepository;

    public boolean addTimeSlotToList(TimeSlot timeSlot) {
        if (ticketRepository.findAll()
                .stream()
                .anyMatch(ticket -> ((Objects.equals(ticket.getId_doctor(), timeSlot.getId_doctor())) &&
                        ((ticket.getTimeOfReceipt().getTime().getTime() + (long) ticket.getDurationInMinutes() * 60 * 1000) > timeSlot.getTimeOfReceipt().getTime().getTime())))) {
            return false;
        }
        ticketRepository.saveAndFlush(new Ticket(timeSlot));
        return true;
    }
}