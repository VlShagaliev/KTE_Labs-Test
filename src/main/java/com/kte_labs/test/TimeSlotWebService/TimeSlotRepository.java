package com.kte_labs.test.TimeSlotWebService;

import jakarta.annotation.PostConstruct;

import java.util.*;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TimeSlotRepository {
    private static List<TimeSlot> timeSlotList = new ArrayList<>();

    @PostConstruct
    private void initData() {
        TimeSlot timeSlot10 = new TimeSlot();
        timeSlot10.setId_doctor(10);
        timeSlot10.setTimeOfReceipt(new GregorianCalendar(2024, Calendar.FEBRUARY, 10, 10, 0));
        timeSlot10.setDurationInMinutes(20);
        timeSlotList.add(timeSlot10);
        TimeSlot timeSlot20 = new TimeSlot();
        timeSlot20.setId_doctor(20);
        timeSlot20.setTimeOfReceipt(new GregorianCalendar(2024, Calendar.MARCH, 15, 15, 0));
        timeSlot20.setDurationInMinutes(30);
        timeSlotList.add(timeSlot20);
    }

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

    public int findTimeSlot(int id_doctor) {
        int response = 0;
        for (TimeSlot timeSlot : timeSlotList) {
            if (timeSlot.getId_doctor() == id_doctor) response = id_doctor;
        }
        return response;
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
}