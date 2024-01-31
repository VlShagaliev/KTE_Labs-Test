package com.kte_labs.test.TimeSlotWebService;

import com.kte_labs.test.Entity.TimeSlot;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(namespace = "http://kte_labs.com/test/TimeSlotWebService", name = "getTimeSlotRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"timeSlot"})
@Getter
@Setter
public class GetTimeSlotRequest {
    private static final String NAMESPACE_URI = "http://kte_labs.com/test/TimeSlotWebService";
    @XmlElement(namespace = NAMESPACE_URI, name = "timeSlot", required = true)
    private TimeSlot timeSlot;
}
