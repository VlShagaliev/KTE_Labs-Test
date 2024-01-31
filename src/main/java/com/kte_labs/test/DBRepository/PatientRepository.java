package com.kte_labs.test.DBRepository;

import com.kte_labs.test.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
