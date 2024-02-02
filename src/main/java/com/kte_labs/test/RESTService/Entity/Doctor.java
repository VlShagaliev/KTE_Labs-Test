package com.kte_labs.test.RESTService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @SequenceGenerator(name = "doc_sequence", sequenceName = "doctors_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_sequence")
    private Integer Id;
    @Column(name = "uuid")
    @GeneratedValue
    private UUID uuid;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "department")
    private String department;
    @Column(name = "post")
    private String post;
}
