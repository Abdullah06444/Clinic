package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.stereotype.Component;

@Component
public class ClinicAppointmentsDtoConverter {

    public ClinicAppointmentsDto convert(ClinicAppointments clinicAppointments) {

        return new ClinicAppointmentsDto(clinicAppointments.getClinicDoctorId(), clinicAppointments.getClinicPatientId(),
                clinicAppointments.getAppointmentStartDate(), clinicAppointments.getAppointmentEndDate());
    }
}
