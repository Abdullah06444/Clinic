package com.secilstore.clinic.dto;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.stereotype.Component;

@Component
public class ClinicAppointmentsDtoConverter {

    public ClinicAppointmentsDto convert(ClinicAppointments clinicAppointments,
                                         Long doctorId, Long patientId) {

        return new ClinicAppointmentsDto(clinicAppointments.getAppointmentId(), doctorId, patientId,
                clinicAppointments.getAppointmentStartDate(), clinicAppointments.getAppointmentEndDate());
    }
}
