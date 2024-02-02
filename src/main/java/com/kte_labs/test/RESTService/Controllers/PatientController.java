package com.kte_labs.test.RESTService.Controllers;

import com.kte_labs.test.RESTService.Entity.Patient;
import com.kte_labs.test.RESTService.Repository.PatientRepository;
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
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    //тестовый метод по получению списка всех пациентов
    @GetMapping
    public ResponseEntity<?> getAllPatients() {
        try {
            final List<Patient> patients = new ArrayList<>(patientRepository.findAll());
            if (patients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    * Метод по получению карточки пациента по его id номеру
    * Запрос отправляется по ссылке http://localhost:8080/patients/{id_patient}
    * */
    @GetMapping("/{id_patient}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(name = "id_patient") int id_patient) {
        try {
            Optional<Patient> patientOptional = patientRepository.findById(id_patient);
            return patientOptional.map(patient -> new ResponseEntity<>(patient, HttpStatus.OK)).
                    orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
