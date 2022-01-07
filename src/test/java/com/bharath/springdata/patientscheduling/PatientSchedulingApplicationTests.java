package com.bharath.springdata.patientscheduling;

import com.bharath.springdata.patientscheduling.model.Appointment;
import com.bharath.springdata.patientscheduling.model.Doctor;
import com.bharath.springdata.patientscheduling.model.Insurance;
import com.bharath.springdata.patientscheduling.model.Patient;
import com.bharath.springdata.patientscheduling.repository.AppointmentRepository;
import com.bharath.springdata.patientscheduling.repository.DoctorRepository;
import com.bharath.springdata.patientscheduling.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientSchedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

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

    @Test
    public void testCreatePatient(){
        Patient patient = new Patient();
        patient.setFirstName("Julia");
        patient.setLastName("Roberts");
        patient.setPhone("123456");

        Insurance insurance = new Insurance();

        insurance.setProviderName("Blue Cross Blue Shield");
        insurance.setCopay(20.0);

        patient.setInsurance(insurance);

        Optional<Doctor> doctor = doctorRepository.findById(1l);
        List<Doctor> doctors = Arrays.asList(doctor.get());

        patient.setDoctors(doctors);

        patientRepository.save(patient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = new Appointment();
        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        appointment.setAppointmentTime(appointmentTime);
        appointment.setReason("Emergency!");
        appointment.setStarted(true);

        appointment.setPatient(patientRepository.findById(1l).get());
        appointment.setDoctor(doctorRepository.findById(1l).get());

        appointmentRepository.save(appointment);

    }

}
