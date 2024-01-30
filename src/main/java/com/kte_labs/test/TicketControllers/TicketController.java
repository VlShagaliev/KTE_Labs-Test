package com.kte_labs.test.TicketControllers;

import com.kte_labs.test.TicketService.TicketService;
import com.kte_labs.test.Entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/{id_doctor}")
    public Ticket getTicket(@PathVariable int id_doctor) {
        return ticketService.getTicket(id_doctor);
    }
}
