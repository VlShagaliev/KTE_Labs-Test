package com.kte_labs.test.WebService;

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
    private String Message;
}
