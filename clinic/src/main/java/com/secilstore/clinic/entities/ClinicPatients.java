package com.secilstore.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name = "CLINIC_PATIENTS")
@Data
public class ClinicPatients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PATIENT_ID", length = 5, nullable = false, unique = true)
    private Long patientId;

    @Column(name = "PATIENT_NAME", length = 50, nullable = false)
    private String patientName;

    @Column(name = "PATIENT_SURNAME", length = 50, nullable = false)
    private String patientSurname;
}
