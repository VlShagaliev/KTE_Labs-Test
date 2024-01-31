package com.kte_labs.test.Services;

import com.kte_labs.test.DBRepository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
}
