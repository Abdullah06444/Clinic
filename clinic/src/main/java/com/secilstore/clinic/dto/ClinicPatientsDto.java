package com.secilstore.clinic.dto;

import lombok.Data;

@Data
public class ClinicPatientsDto {

    private Long patientId;
    private String patientName;
    private String patientSurname;

    public ClinicPatientsDto(Long patientId, String patientName, String patientSurname) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
    }

    public ClinicPatientsDto(String patientName, String patientSurname) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
    }
}
