package com.kte_labs.test.Controllers;

import com.kte_labs.test.DBRepository.TicketRepository;
import com.kte_labs.test.Entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;
    @PostMapping("/set")
    public ResponseEntity<?> create(@RequestBody Ticket ticket) {
        try {
            System.out.println(ticket.getTimeOfReceipt().getTime());
            ticketRepository.saveAndFlush(ticket);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {

            final List<Ticket> tickets = new ArrayList<>(ticketRepository.findAll());
            if (tickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tickets, HttpStatus.OK);

    }

    @GetMapping("/{id_doctor}")
    public ResponseEntity<List<Ticket>> getTicketsByIdDoctor(@PathVariable(name = "id_doctor") int id_doctor) {
        try {
            List<Ticket> ticketsByIdDoctor = new ArrayList<>(ticketRepository.findAll()
                                                .stream()
                                                .filter(ticket -> (ticket.getId_doctor()==id_doctor))
                                                .toList());
            return new ResponseEntity<>(ticketsByIdDoctor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicketById(@PathVariable(name = "id") int id) {
        try {
            ticketRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
