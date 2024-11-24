package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicAppointmentsRepository extends JpaRepository<ClinicAppointments, Integer> {


}
