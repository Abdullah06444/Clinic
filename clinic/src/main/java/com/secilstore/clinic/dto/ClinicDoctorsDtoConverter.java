package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicDoctors;
import org.springframework.stereotype.Component;

@Component
public class ClinicDoctorsDtoConverter {

    public ClinicDoctorsDto convertAllFields(ClinicDoctors clinicDoctors){

        return new ClinicDoctorsDto(clinicDoctors.getDoctorId(), clinicDoctors.getDoctorName(),
                clinicDoctors.getDoctorSurname(), clinicDoctors.getDoctorPerHourFee());
    }

    public ClinicDoctorsDto convertFieldsExceptDoctorId(ClinicDoctors clinicDoctors){

        return new ClinicDoctorsDto(clinicDoctors.getDoctorName(),
                clinicDoctors.getDoctorSurname(), clinicDoctors.getDoctorPerHourFee());
    }
}
