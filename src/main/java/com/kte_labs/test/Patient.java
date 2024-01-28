package com.kte_labs.test;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

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
    private int uuid;
    private String FIO;
    private Calendar birthdate;

}
