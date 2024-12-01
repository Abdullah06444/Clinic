package com.secilstore.clinic.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateClinicAppointmentsDto {

    private LocalDateTime appointmentStartDate;
    private LocalDateTime appointmentEndDate;

    public UpdateClinicAppointmentsDto(LocalDateTime appointmentStartDate, LocalDateTime appointmentEndDate) {
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
    }
}
