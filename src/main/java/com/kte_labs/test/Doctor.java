package com.kte_labs.test;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "Doctors")
@Getter
@Setter
@AllArgsConstructor
@NonNull
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private int uuid;
    private String FIO;
    private String departments;
    private String post;
}
