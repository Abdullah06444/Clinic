package com.secilstore.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity (name = "CLINIC_DOCTORS")
@Data
public class ClinicDoctors {

    // id, doctor_id, name, perHourFee, surname

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLINIC_DOCTORS_SEQ")
    @SequenceGenerator(name = "CLINIC_DOCTORS_SEQ", sequenceName = "CLINIC_DOCTORS_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Column(name = "DOCTOR_ID", length = 5, nullable = false, unique = true)
    private Long doctorId;

    @Column(name = "DOCTOR_NAME", length = 50, nullable = false)
    private String doctorName;

    @Column(name = "DOCTOR_SURNAME", length = 50, nullable = false)
    private String doctorSurname;

    @Column(name = "DOCTOR_FEE", nullable = false, precision = 6, scale = 2)
    private BigDecimal doctorPerHourFee;
}
