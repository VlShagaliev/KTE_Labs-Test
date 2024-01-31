package com.kte_labs.test.DBRepository;

import com.kte_labs.test.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
