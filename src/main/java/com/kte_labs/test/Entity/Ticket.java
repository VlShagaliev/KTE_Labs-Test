package com.kte_labs.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "TICKETS")
public class Ticket{
    private int id_doctor;
    private int id_patients;
    private int durationInMinutes;
}
