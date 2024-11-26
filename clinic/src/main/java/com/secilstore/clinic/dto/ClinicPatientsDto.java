package com.secilstore.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClinicPatientsDto {

    private Long patientId;
    private String patientName;
    private String patientSurname;
}
