package com.kte_labs.test.RESTService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kte_labs.test.WebService.TimeSlot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;

@Entity
@Table(name = "tickets", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_doctor")
    private Integer id_doctor;
    @Column(name = "id_patient")
    private Integer id_patient;
    @Column(name = "time_of_receipt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Yekaterinburg")
    private GregorianCalendar timeOfReceipt;
    @Column(name = "duration_in_minutes")
    private int durationInMinutes;

    public Ticket(TimeSlot timeSlot) {
        this.id_doctor = timeSlot.getId_doctor();
        this.timeOfReceipt = timeSlot.getTimeOfReceipt();
        this.durationInMinutes = timeSlot.getDurationInMinutes();
    }
}
