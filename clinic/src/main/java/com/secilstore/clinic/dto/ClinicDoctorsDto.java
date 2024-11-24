package com.secilstore.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClinicDoctorsDto {

    private Long id;
    private Long doctorId;
    private String doctorName;
    private String doctorSurname;
    private Double doctorPerHourFee;
}
