package com.kte_labs.test.RESTService.Services;

import com.kte_labs.test.RESTService.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
}
