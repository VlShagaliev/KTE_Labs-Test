package com.kte_labs.test.TimeSlotWebService;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.GregorianCalendar;


@XmlRootElement(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "getTimeSlotRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id_doctor", "timeOfReceipt", "durationInMinutes"})
@Getter
@Setter
public class GetTimeSlotRequest {
    private static final String NAMESPACE_URI = "http://kte_labs.com/test/TimeSlotWebService";
    @XmlElement(namespace = NAMESPACE_URI, name = "id_doctor", required = true)
    private int id_doctor;
    @XmlElement(namespace = NAMESPACE_URI, name = "timeOfReceipt", required = true)
    private GregorianCalendar timeOfReceipt;
    @XmlElement(namespace = NAMESPACE_URI, name = "durationInMinutes", required = true)
    private int durationInMinutes;
}
