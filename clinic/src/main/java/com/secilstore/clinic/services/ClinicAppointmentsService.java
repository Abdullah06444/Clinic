package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.dto.ClinicAppointmentsDtoConverter;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.utils.GenerateUniqueEntityIds;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClinicAppointmentsService {

    private final ClinicAppointmentsDtoConverter clinicAppointmentsDtoConverter;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;
    private final ClinicDoctorsService clinicDoctorsService;
    private final ClinicPatientsService clinicPatientsService;
    private final GenerateUniqueEntityIds generateUniqueEntityIds;

    public Optional<ClinicAppointments> saveClinicAppointments(ClinicAppointmentsDto clinicAppointmentsDto) {

        Optional<ClinicDoctors> foundClinicDoctors = clinicDoctorsService.getClinicDoctors(clinicAppointmentsDto.getClinicDoctorId());
        Optional<ClinicPatients> foundClinicPatients = clinicPatientsService.getClinicPatients(clinicAppointmentsDto.getClinicPatientId());
        if(foundClinicDoctors.isPresent() && foundClinicPatients.isPresent()) {

            ClinicAppointments saveClinicAppointments = new ClinicAppointments();
            saveClinicAppointments.setAppointmentId(generateUniqueEntityIds.generateUniqueEntityId());
            saveClinicAppointments.setClinicDoctors(foundClinicDoctors.get());
            saveClinicAppointments.setClinicPatients(foundClinicPatients.get());
            saveClinicAppointments.setAppointmentStartDate(clinicAppointmentsDto.getAppointmentStartDate());
            saveClinicAppointments.setAppointmentEndDate(clinicAppointmentsDto.getAppointmentEndDate());
            return Optional.of(clinicAppointmentsRepository.save(saveClinicAppointments));
        }
        return Optional.empty();
    }

    public Optional<List<ClinicAppointmentsDto>> listClinicAppointments() {

        return Optional.of(clinicAppointmentsRepository.findAll()
                .stream().map(clinicAppointmentsDtoConverter::convertAllFields).toList());
    }

    public Optional<ClinicAppointments> getClinicAppointments(Long appointmentId) {

        return Optional.ofNullable(clinicAppointmentsRepository.findByAppointmentId(appointmentId));
    }

    public Optional<Integer> updateClinicAppointments(Long appointmentId, ClinicAppointmentsDto clinicAppointmentsDto) {

        return clinicAppointmentsRepository.updateAppointmentStartDateAndAppointmentEndDateByAppointmentId(appointmentId,
                clinicAppointmentsDto.getAppointmentStartDate(), clinicAppointmentsDto.getAppointmentEndDate());
    }

    public Optional<Integer> deleteClinicAppointments(Long appointmentId) {

        return Optional.of(clinicAppointmentsRepository.deleteClinicAppointmentByAppointmentId(appointmentId));
    }
}
