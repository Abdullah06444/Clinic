package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicDoctors;
import org.springframework.stereotype.Component;

@Component
public class ClinicDoctorsDtoConverter {

    public ClinicDoctorsDto convert(ClinicDoctors clinicDoctors){

        return new ClinicDoctorsDto(clinicDoctors.getDoctorId(), clinicDoctors.getDoctorName(),
                clinicDoctors.getDoctorSurname(), clinicDoctors.getDoctorPerHourFee());
    }
}
