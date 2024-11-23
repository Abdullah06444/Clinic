package com.secilstore.clinic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class ClinicAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DOCTOR_ID")
    private long doctor_id;

    @Column(name = "PATIENT_ID", length = 5, nullable = false, unique = true)
    private long patient_id;

    @Column(name = "START_DATE", nullable = false, updatable = true)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false, updatable = true)
    private LocalDateTime endDate;
}
