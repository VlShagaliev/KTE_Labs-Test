package com.kte_labs.test.RESTService.Repository;

import com.kte_labs.test.RESTService.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
