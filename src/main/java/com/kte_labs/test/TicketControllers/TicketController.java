package com.kte_labs.test.TicketControllers;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;

    @PostMapping(value = "/set")
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        System.out.println(ticket.getTimeOfReceipt().getTime());
        ticketRepository.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        final List<Ticket> tickets = new ArrayList<>(ticketRepository.findAll());
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticket> getTicketsByIdDoctor(@PathVariable(name = "id") int id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.map(ticket -> new ResponseEntity<>(ticket, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTicketById(@PathVariable(name = "id") int id) {
        try {
            ticketRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
