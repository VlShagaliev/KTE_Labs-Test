package com.kte_labs.test.RESTService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @SequenceGenerator(name = "pat_sequence", sequenceName = "patients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pat_sequence")
    private Integer id;
    @Column(name = "uuid")
    @GeneratedValue
    private UUID uuid;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "asia/yekaterinburg")
    private Calendar birthdate;

}
