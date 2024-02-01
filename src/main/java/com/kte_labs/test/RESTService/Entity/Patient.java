package com.kte_labs.test.RESTService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "patients", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "asia/yekaterinburg")
    private Calendar birthdate;

}
