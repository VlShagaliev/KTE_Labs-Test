package com.kte_labs.test.TimeSlotWebService;

import jakarta.annotation.PostConstruct;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class TimeSlotRepository {
    private static List<TimeSlot> timeSlotList = new ArrayList<>();

    @PostConstruct
    public void initData() {
        TimeSlot timeSlot10 = new TimeSlot();
        timeSlot10.setId_doctor(10);
        timeSlot10.setTimeOfReceipt(new GregorianCalendar(2024, Calendar.FEBRUARY, 10, 10, 00));
        timeSlot10.setDurationInMinutes(20);
        timeSlotList.add(timeSlot10);
        TimeSlot timeSlot20 = new TimeSlot();
        timeSlot20.setId_doctor(20);
        timeSlot20.setTimeOfReceipt(new GregorianCalendar(2024, Calendar.MARCH, 15, 15, 00));
        timeSlot20.setDurationInMinutes(30);
        timeSlotList.add(timeSlot20);
    }
    public int countTimeSlotList(){
        return timeSlotList.size();
    }
    public int findTimeSlot(int id_doctor) {
        int response = 0;
        for (TimeSlot timeSlot : timeSlotList) {
            if (timeSlot.getId_doctor() == id_doctor) response = id_doctor;
        }
        return response;
    }
}