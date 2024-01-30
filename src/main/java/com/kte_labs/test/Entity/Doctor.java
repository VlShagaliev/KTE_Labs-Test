package com.kte_labs.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "DOCTORS")
@Getter
@Setter
@AllArgsConstructor
@NonNull
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private UUID uuid;
    private String FIO;
    private String departments;
    private String post;
}
