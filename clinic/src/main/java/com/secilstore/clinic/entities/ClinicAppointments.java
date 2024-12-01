package com.secilstore.clinic.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity(name = "CLINIC_APPOINTMENTS")
@Data
public class ClinicAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLINIC_APPOINTMENTS_SEQ")
    @SequenceGenerator(name = "CLINIC_APPOINTMENTS_SEQ", sequenceName = "CLINIC_APPOINTMENTS_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Column(name = "APPOINTMENT_ID", length = 5, nullable = false, unique = true)
    private Long appointmentId;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCTOR_ID", referencedColumnName = "DOCTOR_ID", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE) // Patients sildiğimizde onun randevusuna bağlı doktor silinmesin diye comment line
//    @JsonIgnore
    private ClinicDoctors clinicDoctors;

    @OneToOne //(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = false, unique = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private ClinicPatients clinicPatients;

    @Column(name = "START_DATE", nullable = false, updatable = true)
    private LocalDateTime appointmentStartDate;

    @Column(name = "END_DATE", nullable = false, updatable = true)
    private LocalDateTime appointmentEndDate;
}
