package com.secilstore.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "CLINIC_APPOINTMENTS")
@Data
public class ClinicAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DOCTOR_ID")
    private long clinicDoctorId;

    @Column(name = "PATIENT_ID", length = 5, nullable = false, unique = true)
    private long clinicPatientId;

    @Column(name = "START_DATE", nullable = false, updatable = true)
    private LocalDateTime appointmentStartDate;

    @Column(name = "END_DATE", nullable = false, updatable = true)
    private LocalDateTime appointmentEndDate;
}
