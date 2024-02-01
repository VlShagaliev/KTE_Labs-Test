package com.kte_labs.test.WebService;

import com.kte_labs.test.RESTService.Repository.TicketRepository;
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
                        ((ticket.getTimeOfReceipt().getTimeInMillis() + (long) ticket.getDurationInMinutes() * 60 * 1000) > timeSlot.getTimeOfReceipt().getTimeInMillis())
                ))
        ) {
            return false;
        }
        ticketRepository.save(new Ticket(timeSlot));
        return true;
    }
}
