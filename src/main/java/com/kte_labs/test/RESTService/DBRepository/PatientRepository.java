package com.kte_labs.test.RESTService.DBRepository;

import com.kte_labs.test.RESTService.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
