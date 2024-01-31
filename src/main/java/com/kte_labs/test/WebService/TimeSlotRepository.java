package com.kte_labs.test.WebService;

import com.kte_labs.test.RESTService.DBRepository.TicketRepository;
import com.kte_labs.test.RESTService.Entity.Ticket;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component

public class TimeSlotRepository {
    @Autowired
    private TicketRepository ticketRepository;

    public boolean addTimeSlotToList(TimeSlot timeSlot) {
        if (ticketRepository.findAll()
                .stream()
                .anyMatch(test -> ((test.getId_doctor() == timeSlot.getId_doctor()) &&
                        ((test.getTimeOfReceipt().getTime().getTime() + test.getDurationInMinutes() * 60 * 1000) > timeSlot.getTimeOfReceipt().getTime().getTime())))) {
            return false;
        }
        ticketRepository.saveAndFlush(new Ticket(timeSlot));
        return true;
    }
}
