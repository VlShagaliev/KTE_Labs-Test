package com.kte_labs.test.TimeSlotWebService;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeSLot", propOrder = {
        "id_doctor",
        "timeOfReceipt",
        "durationInMinutes"
})
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @XmlElement(required = true)
    private int id_doctor;
    @XmlElement(required = true)
    private GregorianCalendar timeOfReceipt;
    @XmlElement(required = true)
    private int durationInMinutes;
}
