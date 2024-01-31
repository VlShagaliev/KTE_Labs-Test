package com.kte_labs.test.Services;

import com.kte_labs.test.DBRepository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
}
