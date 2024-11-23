package com.secilstore.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClinicDoctors {

    // id, doctor_id, name, perHourFee, surname

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DOCTOR_ID", length = 5, nullable = false, unique = true)
    private long doctor_id;

    @Column(name = "DOCTOR_NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "DOCTOR_SURNAME", length = 50, nullable = false)
    private String surname;

    @Column(name = "DOCTOR_FEE", nullable = false, precision = 4, scale = 2)
    private double perHourFee;
}
