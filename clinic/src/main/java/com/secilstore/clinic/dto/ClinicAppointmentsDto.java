package com.secilstore.clinic.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClinicAppointmentsDto {

    private Long appointmentId;
    private Long clinicDoctorId;
    private Long clinicPatientId;
    private LocalDateTime appointmentStartDate;
    private LocalDateTime appointmentEndDate;

    public ClinicAppointmentsDto() {}

    public ClinicAppointmentsDto(Long appointmentId, Long clinicDoctorId, Long clinicPatientId, LocalDateTime appointmentStartDate, LocalDateTime appointmentEndDate) {

        this.appointmentId = appointmentId;
        this.clinicDoctorId = clinicDoctorId;
        this.clinicPatientId = clinicPatientId;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
    }

    public ClinicAppointmentsDto(Long clinicDoctorId, Long clinicPatientId, LocalDateTime appointmentStartDate, LocalDateTime appointmentEndDate) {

        this.clinicDoctorId = clinicDoctorId;
        this.clinicPatientId = clinicPatientId;
        this.appointmentStartDate = appointmentStartDate;
        this.appointmentEndDate = appointmentEndDate;
    }

    public ClinicAppointmentsDto(Long clinicDoctorId, Long clinicPatientId) {

        this.clinicDoctorId = clinicDoctorId;
        this.clinicPatientId = clinicPatientId;
    }

    public ClinicAppointmentsDto(LocalDateTime appointmentEndDate, LocalDateTime appointmentStartDate) {
        this.appointmentEndDate = appointmentEndDate;
        this.appointmentStartDate = appointmentStartDate;
    }
}
