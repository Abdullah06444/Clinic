package com.secilstore.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ClinicDoctorsDto {

    private Long doctorId;
    private String doctorName;
    private String doctorSurname;
    private BigDecimal doctorPerHourFee;
}
