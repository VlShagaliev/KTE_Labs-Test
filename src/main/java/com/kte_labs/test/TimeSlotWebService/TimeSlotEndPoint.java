package com.kte_labs.test.TimeSlotWebService;

import com.kte_labs.test.DBRepository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.sql.PreparedStatement;

@Endpoint
public class TimeSlotEndPoint {
    private static final String NAMESPACE_URI = "http://kte_labs.com/test/TimeSlotWebService";
    @Autowired
    TicketRepository ticketRepository;
    public TimeSlotEndPoint(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTimeSlotRequest")
    @ResponsePayload
    public GetTimeSlotResponse getTimeSlot(@RequestPayload GetTimeSlotRequest request) {
        GetTimeSlotResponse response = new GetTimeSlotResponse();
        String sqlRequest = "insert into tickets (id_doctor, time_of_receipt, duration_in_minutes) values ("
                + request.getTimeSlot().getId_doctor() + ", " + request.getTimeSlot().getTimeOfReceipt().toString() +
                ", " + request.getTimeSlot().getDurationInMinutes();
        //PreparedStatement ps =
        if (ticketRepository.addTimeSlotInTicket(request.getTimeSlot(), ticketRepository)) {
            response.setMessage("Время приема врача добавлено");
        } else {
            response.setMessage("Данное время у этого врача занято");
        }
        return response;
    }
}
