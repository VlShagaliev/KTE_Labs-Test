/*
package com.kte_labs.test.TimeSlotWebService;

import com.kte_labs.test.Entity.Ticket;
import com.kte_labs.test.Entity.TimeSlot;
import jakarta.annotation.PostConstruct;

import java.util.*;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Getter
@Component

public class TimeSlotRepository {
    private static List<TimeSlot> timeSlotList = new ArrayList<>();
    public boolean addTimeSlotToList(TimeSlot timeSlot) {
        if (timeSlotList
                .stream()
                .anyMatch(test -> ((test.getId_doctor() == timeSlot.getId_doctor()) &&
                        ((test.getTimeOfReceipt().getTime().getTime() + test.getDurationInMinutes() * 60 * 1000) > timeSlot.getTimeOfReceipt().getTime().getTime())))) {
            return false;
        }
        timeSlotList.add(timeSlot);
        return true;
    }

    public void printAllTimeSlot() {
        for (TimeSlot timeSlot : timeSlotList) {
            System.out.println("\nId Доктора: " + timeSlot.getId_doctor() +
                    " \nВремя приема: " + timeSlot.getTimeOfReceipt().get(Calendar.YEAR) + "-" +
                    timeSlot.getTimeOfReceipt().get(Calendar.MONTH) + "-" +
                    timeSlot.getTimeOfReceipt().get(Calendar.DAY_OF_MONTH) + " " +
                    timeSlot.getTimeOfReceipt().get(Calendar.HOUR) + ":" + timeSlot.getTimeOfReceipt().get(Calendar.MINUTE) +
                    " \nДлительность приема: " + timeSlot.getDurationInMinutes());
        }
    }
}*/
