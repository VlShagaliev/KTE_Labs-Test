package com.kte_labs.test.TimeSlotWebService;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.TimeSlot;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepositoryCustom {
    boolean addTimeSlotInTicket(TimeSlot timeSlot, TicketRepository ticketRepository);
}
