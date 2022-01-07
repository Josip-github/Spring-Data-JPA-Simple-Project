package com.bharath.springdata.patientscheduling.repository;

import com.bharath.springdata.patientscheduling.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
