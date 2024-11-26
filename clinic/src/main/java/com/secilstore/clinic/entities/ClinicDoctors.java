package com.secilstore.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name = "CLINIC_DOCTORS")
@Data
public class ClinicDoctors {

    // id, doctor_id, name, perHourFee, surname

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DOCTOR_ID", length = 5, nullable = false, unique = true)
    private Long doctorId;

    @Column(name = "DOCTOR_NAME", length = 50, nullable = false)
    private String doctorName;

    @Column(name = "DOCTOR_SURNAME", length = 50, nullable = false)
    private String doctorSurname;

    @Column(name = "DOCTOR_FEE", nullable = false/*, precision = 4, scale = 2*/)
    private Double doctorPerHourFee;
}
