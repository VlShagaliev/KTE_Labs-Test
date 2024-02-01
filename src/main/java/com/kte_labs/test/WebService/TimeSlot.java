package com.kte_labs.test.WebService;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;
import java.util.TimeZone;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "timeSlot", propOrder = {
        "id_doctor",
        "timeOfReceipt",
        "durationInMinutes"
})
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @XmlElement(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "id_doctor", required = true)
    private Integer id_doctor;
    @XmlElement(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "timeOfReceipt", required = true)
    private GregorianCalendar timeOfReceipt;
    @XmlElement(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "durationInMinutes", required = true)
    private int durationInMinutes;
}

