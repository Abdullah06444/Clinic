package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.dto.ClinicAppointmentsDtoConverter;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClinicAppointmentsService {

    private final ClinicAppointmentsDtoConverter clinicAppointmentsDtoConverter;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;

    public ClinicAppointments saveClinicAppointments(ClinicAppointments clinicAppointments) {

        return clinicAppointmentsRepository.save(clinicAppointments);
    }

    public List<ClinicAppointmentsDto> listClinicAppointments() {

        return clinicAppointmentsRepository.findAll()
                .stream().map(clinicAppointmentsDtoConverter::convert).toList();
    }
}
