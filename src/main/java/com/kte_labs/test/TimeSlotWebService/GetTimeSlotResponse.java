package com.kte_labs.test.TimeSlotWebService;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "getTimeSlotResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Message"
})
@Getter
@Setter
public class GetTimeSlotResponse {
    @XmlElement(required = true)
    protected String Message;
}
