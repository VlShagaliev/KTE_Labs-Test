package com.kte_labs.test.TicketService;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    public void testTicketRepository(){
        Optional<Ticket> ticketOptional = ticketRepository.findById(10);
    }
}
