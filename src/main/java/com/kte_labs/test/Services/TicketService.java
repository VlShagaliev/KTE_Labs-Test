package com.kte_labs.test.Services;

import com.kte_labs.test.Entity.Ticket;
import com.kte_labs.test.Entity.TimeSlot;
import org.springframework.stereotype.Component;

@Component
public interface TicketService {
    public Ticket saveAndFlushTicket(TimeSlot timeSlot);
    public Ticket getTicket(int id);
}
