package com.secilstore.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ClinicAppointmentsDto {

    private Long clinicDoctorId;
    private Long clinicPatientId;
    private LocalDateTime appointmentStartDate;
    private LocalDateTime appointmentEndDate;
}
