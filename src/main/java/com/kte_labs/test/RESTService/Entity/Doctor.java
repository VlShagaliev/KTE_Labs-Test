package com.kte_labs.test.RESTService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "department")
    private String department;
    @Column(name = "post")
    private String post;
}
