package com.kte_labs.test.RESTService.Services;

import com.kte_labs.test.RESTService.DBRepository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
}
