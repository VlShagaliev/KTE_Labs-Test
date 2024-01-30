package com.kte_labs.test.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "Patients")
@NonNull
@Getter
@Setter
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private UUID uuid;
    private String FIO;
    private Calendar birthdate;

}
