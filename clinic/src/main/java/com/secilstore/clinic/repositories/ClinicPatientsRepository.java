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

    ClinicPatients findByPatientId(Long patientId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLINIC_PATIENTS p SET p.PATIENT_NAME = ?2 WHERE p.PATIENT_ID = ?1", nativeQuery = true)
    Optional<Integer> updatePatientNameByPatientId(Long patientId, String patientName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLINIC_PATIENTS p WHERE p.PATIENT_ID = ?1", nativeQuery = true)
    Integer deleteClinicPatientByPatientId(Long patientId);
}
