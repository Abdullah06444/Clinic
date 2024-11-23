package com.secilstore.clinic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ClinicPatients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PATIENT_ID", length = 5, nullable = false, unique = true)
    private long patient_id;

    @Column(name = "PATIENT_NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "PATIENT_SURNAME", length = 50, nullable = false)
    private String surname;
}
