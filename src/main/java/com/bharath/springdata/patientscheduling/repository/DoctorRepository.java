package com.bharath.springdata.patientscheduling.repository;

import com.bharath.springdata.patientscheduling.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
