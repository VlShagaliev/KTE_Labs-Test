package com.kte_labs.test.TimeSlotWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TimeSlotEndPoint {
    private static final String NAMESPACE_URI = "http://kte_labs.com/test/TimeSlotWebService";

    private TimeSlotRepository timeSlotRepository;

    @Autowired
    public TimeSlotEndPoint(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTimeSlotRequest")
    @ResponsePayload
    public GetTimeSlotResponse getTimeSlot(@RequestPayload GetTimeSlotRequest request) {
        GetTimeSlotResponse response = new GetTimeSlotResponse();
        if (timeSlotRepository.addTimeSlotToList(request.getTimeSlot())) {
            response.setMessage("Время приема врача добавлено");
        } else {
            response.setMessage("Данное время у этого врача занято");
        }
        timeSlotRepository.printAllTimeSlot();
        return response;
    }
}
