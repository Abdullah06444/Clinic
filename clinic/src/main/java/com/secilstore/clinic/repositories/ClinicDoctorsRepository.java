package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicDoctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClinicDoctorsRepository extends JpaRepository<ClinicDoctors, Integer> {

    @Query("SELECT MAX(clinicDoctors.id) FROM CLINIC_DOCTORS clinicDoctors")
    Integer findMaxId();

    @Modifying
    @Transactional
    @Query(value = "CREATE SEQUENCE IF NOT EXISTS CLINIC_DOCTORS_SEQUENCE START WITH ?1", nativeQuery = true)
    void createSequenceIfNotExists(Integer restartWith);

    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE CLINIC_DOCTORS_SEQUENCE RESTART WITH ?1", nativeQuery = true)
    void resetSequence(Integer restartWith);
}
