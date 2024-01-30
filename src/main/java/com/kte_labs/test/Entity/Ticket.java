package com.kte_labs.test.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.GregorianCalendar;

@Entity
@Getter
@Setter
@Table(name = "tickets")
@NoArgsConstructor
public class Ticket {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "id_doctor")
    private int id_doctor;
    @Column(name = "id_patient")
    private int id_patient;
    @Column(name = "time_of_receipt")
    private GregorianCalendar timeOfReceipt;
    @Column(name = "duration_in_minutes")
    private int durationInMinutes;
}
