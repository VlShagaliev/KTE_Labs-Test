package com.kte_labs.test.RESTService.Controllers;

import com.kte_labs.test.RESTService.Entity.Ticket;
import com.kte_labs.test.RESTService.Repository.TicketRepository;
import com.kte_labs.test.WebService.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;

    //тестовый метод POST для проверки работоспособности внесения данных в Ticket альтернативным способом
    @PostMapping("/slot/{id_slot}")
    public ResponseEntity<Ticket> postTicket(@PathVariable("id_slot") int id_slot,
                                             @RequestParam("id_patient") int id_patient,
                                             @RequestParam("timeOfReceipt") String timeOfReceipt,
                                             @RequestParam("durationInMinutes") int durationInMinutes) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(timeOfReceipt);
            GregorianCalendar dateOfReceipt = new GregorianCalendar();
            dateOfReceipt.setTime(date);
            TimeSlot timeSlot = new TimeSlot(id_patient, dateOfReceipt, durationInMinutes);
            return new ResponseEntity<>(ticketRepository.saveAndFlush(new Ticket(timeSlot)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        try {
            final List<Ticket> tickets = ticketRepository.findAll();
            if (tickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
        Запрос отправляется по ссылке http://localhost:8080/tickets/{id_doctor}?date_receipt={timeOfReceipt}
        date_receipt пишется в формате yyyy-MM-dd
         */
    @GetMapping("/{id_doctor}")
    public ResponseEntity<List<Ticket>> getTicketsByIdDoctor(@PathVariable(name = "id_doctor") int id_doctor,
                                                             @RequestParam(name = "date_receipt") String timeOfReceipt) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(timeOfReceipt);
            Calendar dateOfReceipt = Calendar.getInstance();
            dateOfReceipt.setTime(date);
            List<Ticket> ticketsByIdDoctor = ticketRepository.findAll()
                    .stream()
                    .filter(ticket -> (ticket.getId_doctor() == id_doctor)
                            && (ticket.getId_patient() == null)
                            && (ticket.getTimeOfReceipt().get(Calendar.YEAR) == dateOfReceipt.get(Calendar.YEAR))
                            && (ticket.getTimeOfReceipt().get(Calendar.MONTH) == dateOfReceipt.get(Calendar.MONTH))
                            && (ticket.getTimeOfReceipt().get(Calendar.DAY_OF_MONTH) == dateOfReceipt.get(Calendar.DAY_OF_MONTH))
                    )
                    .toList();
            return new ResponseEntity<>(ticketsByIdDoctor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    Запрос отправляется по ссылке http://localhost:8080/tickets/slot/{id_slot}?id_patient={id_patient}
     */
    @PatchMapping("/slot/{id_slot}")
    public ResponseEntity<Ticket> patchTicket(@PathVariable("id_slot") int id_slot,
                                              @RequestParam("id_patient") int id_patient) {
        try {
            Optional<Ticket> ticketOptional = ticketRepository.findById(id_slot);
            if (ticketOptional.isPresent() && (ticketOptional.get().getId_patient() == null)) {
                Ticket ticket = ticketOptional.get();
                ticket.setId_patient(id_patient);
                return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
