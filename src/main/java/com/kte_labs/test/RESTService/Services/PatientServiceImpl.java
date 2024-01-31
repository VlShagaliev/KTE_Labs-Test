package com.kte_labs.test.RESTService.Services;

import com.kte_labs.test.RESTService.DBRepository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
}
