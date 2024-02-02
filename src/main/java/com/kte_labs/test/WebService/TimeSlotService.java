package com.kte_labs.test.WebService;

import com.kte_labs.test.RESTService.Entity.Ticket;
import com.kte_labs.test.RESTService.Repository.TicketRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Getter
@Service
public class TimeSlotService {

    @Autowired
    private TicketRepository ticketRepository;
    /*
    * Метод по добавлению тикета полученного из SOAP сервиса в БД с условием, что новый тикет не попадает в существующий тикет
    * с учетом длительности приема врача
    * */
    public boolean addTimeSlotToList(TimeSlot timeSlot) {
        if (ticketRepository.findAll()
                .stream()
                .anyMatch(ticket -> (Objects.equals(ticket.getId_doctor(), timeSlot.getId_doctor())) &&
                        (((ticket.getTimeOfReceipt().getTimeInMillis() + (long) ticket.getDurationInMinutes() * 60 * 1000)
                                > timeSlot.getTimeOfReceipt().getTimeInMillis())
                                && (ticket.getTimeOfReceipt().getTimeInMillis()
                                    < (timeSlot.getTimeOfReceipt().getTimeInMillis() + (long) timeSlot.getDurationInMinutes() * 60 * 1000)))
                )
        ) {
            return false;
        }
        ticketRepository.saveAndFlush(new Ticket(timeSlot));
        return true;
    }
}
