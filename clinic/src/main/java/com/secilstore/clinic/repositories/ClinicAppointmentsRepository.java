package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClinicAppointmentsRepository extends JpaRepository<ClinicAppointments, Integer> {

    @Query("SELECT MAX(clinicAppointments.id) FROM CLINIC_APPOINTMENTS clinicAppointments")
    Integer findMaxId();

    @Modifying
    @Transactional
    @Query(value = "CREATE SEQUENCE IF NOT EXISTS CLINIC_APPOINTMENTS_SEQUENCE START WITH ?1", nativeQuery = true)
    void createSequenceIfNotExists(Integer restartWith);

    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE CLINIC_APPOINTMENTS_SEQUENCE RESTART WITH ?1", nativeQuery = true)
    void resetSequence(Integer restartWith);
}
