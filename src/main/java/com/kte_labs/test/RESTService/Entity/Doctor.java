package com.kte_labs.test.RESTService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "doctors", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "department")
    private String department;
    @Column(name = "post")
    private String post;
}
