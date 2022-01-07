package com.bharath.springdata.patientscheduling.repository;

import com.bharath.springdata.patientscheduling.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
