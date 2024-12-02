package com.secilstore.clinic.repositories;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

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

    ClinicAppointments findByAppointmentId(Long appointmentId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CLINIC_APPOINTMENTS a SET a.START_DATE = ?2, a.END_DATE = ?3 WHERE a.APPOINTMENT_ID = ?1", nativeQuery = true)
    Optional<Integer> updateAppointmentStartDateAndAppointmentEndDateByAppointmentId(Long patientId, LocalDateTime startDate, LocalDateTime endDate);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLINIC_APPOINTMENTS a WHERE a.DOCTOR_ID = ?1", nativeQuery = true)
    void deleteClinicAppointmentsByDoctorId(Long doctorId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLINIC_APPOINTMENTS a WHERE a.PATIENT_ID = ?1", nativeQuery = true)
    void deleteClinicAppointmentByPatientId(Long patientId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CLINIC_APPOINTMENTS a WHERE a.APPOINTMENT_ID = ?1", nativeQuery = true)
    Integer deleteClinicAppointmentByAppointmentId(Long appointmentId);
}
