package com.kte_labs.test.RESTService.Services;

import com.kte_labs.test.RESTService.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
}
