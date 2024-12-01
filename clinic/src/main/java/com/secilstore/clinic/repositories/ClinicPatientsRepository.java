package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClinicPatientsRepository extends JpaRepository<ClinicPatients, Integer> {

    @Query("SELECT MAX(clinicPatients.id) FROM CLINIC_PATIENTS clinicPatients")
    Integer findMaxId();

    @Modifying
    @Transactional
    @Query(value = "CREATE SEQUENCE IF NOT EXISTS CLINIC_PATIENTS_SEQUENCE START WITH ?1", nativeQuery = true)
    void createSequenceIfNotExists(Integer restartWith);

    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE CLINIC_PATIENTS_SEQUENCE RESTART WITH ?1", nativeQuery = true)
    void resetSequence(Integer restartWith);

    Optional<ClinicPatients> findByPatientId(Long patientId);

    @Modifying
    @Transactional
    void deleteByPatientId(Long patientId);
}
