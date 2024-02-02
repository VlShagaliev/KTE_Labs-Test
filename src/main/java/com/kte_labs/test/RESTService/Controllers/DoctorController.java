package com.kte_labs.test.RESTService.Controllers;

import com.kte_labs.test.RESTService.Entity.Doctor;
import com.kte_labs.test.RESTService.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        try {
            final List<Doctor> doctors = new ArrayList<>(doctorRepository.findAll());
            if (doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id_doctor}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(name = "id_doctor") int id_doctor) {
        try {
            Optional<Doctor> doctorOptional = doctorRepository.findById(id_doctor);
            return doctorOptional.map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK)).
                    orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
