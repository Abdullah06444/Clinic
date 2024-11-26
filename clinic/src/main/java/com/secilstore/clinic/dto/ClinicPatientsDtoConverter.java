package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicPatients;
import org.springframework.stereotype.Component;

@Component
public class ClinicPatientsDtoConverter {

    public ClinicPatientsDto convert(ClinicPatients clinicPatients) {

        return new ClinicPatientsDto(clinicPatients.getPatientId(), clinicPatients.getPatientName(),
                clinicPatients.getPatientSurname());
    }
}
