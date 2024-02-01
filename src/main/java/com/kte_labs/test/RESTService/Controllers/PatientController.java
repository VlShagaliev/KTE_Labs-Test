package com.kte_labs.test.RESTService.Controllers;

import com.kte_labs.test.RESTService.Repository.PatientRepository;
import com.kte_labs.test.RESTService.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping
    public ResponseEntity<?> getAllPatients(){
        try {
            final List<Patient> patients = new ArrayList<>(patientRepository.findAll());
            if (patients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id_patients}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(name = "id_patients") int id_patients) {
        try {
            Optional<Patient> patientOptional = patientRepository.findById(id_patients);
            return patientOptional.map(patient -> new ResponseEntity<>(patient, HttpStatus.OK)).
                    orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
