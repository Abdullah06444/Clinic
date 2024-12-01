package com.secilstore.clinic.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClinicDoctorsDto {

    private Long doctorId;
    private String doctorName;
    private String doctorSurname;
    private BigDecimal doctorPerHourFee;

    public ClinicDoctorsDto(Long doctorId, String doctorName, String doctorSurname, BigDecimal doctorPerHourFee) {

        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorPerHourFee = doctorPerHourFee;
    }

    public ClinicDoctorsDto(String doctorName, String doctorSurname, BigDecimal doctorPerHourFee) {

        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorPerHourFee = doctorPerHourFee;
    }
}
