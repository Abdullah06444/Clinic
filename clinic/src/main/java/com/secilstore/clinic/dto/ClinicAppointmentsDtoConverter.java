package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.stereotype.Component;

@Component
public class ClinicAppointmentsDtoConverter {

    public ClinicAppointmentsDto convertAllFields(ClinicAppointments clinicAppointments) {

        return new ClinicAppointmentsDto(clinicAppointments.getAppointmentId(),
                clinicAppointments.getClinicDoctors().getDoctorId(),
                clinicAppointments.getClinicPatients().getPatientId(),
                clinicAppointments.getAppointmentStartDate(), clinicAppointments.getAppointmentEndDate());
    }

    public ClinicAppointmentsDto convertFieldsExceptAppointmentId(ClinicAppointments clinicAppointments) {

        return new ClinicAppointmentsDto(clinicAppointments.getClinicDoctors().getDoctorId(),
                clinicAppointments.getClinicPatients().getPatientId(),
                clinicAppointments.getAppointmentStartDate(), clinicAppointments.getAppointmentEndDate());
    }
}
