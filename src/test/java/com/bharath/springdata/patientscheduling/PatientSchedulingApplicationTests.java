package com.bharath.springdata.patientscheduling;

import com.bharath.springdata.patientscheduling.model.Doctor;
import com.bharath.springdata.patientscheduling.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientSchedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateDoctor(){
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Brown");
        doctor.setSpeciality("All");

        doctorRepository.save(doctor);
    }

}
