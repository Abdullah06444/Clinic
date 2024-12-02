package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicPatientsDtoConverter;
import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import com.secilstore.clinic.utils.GenerateUniqueEntityIds;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClinicPatientsService {

    private final ClinicPatientsDtoConverter clinicPatientsDtoConverter;
    private final ClinicPatientsRepository clinicPatientsRepository;
    private final GenerateUniqueEntityIds generateUniqueEntityIds;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;

    public Optional<ClinicPatients> saveClinicPatients(ClinicPatientsDto clinicPatientsDto) {

        ClinicPatients clinicPatients = new ClinicPatients();
        clinicPatients.setPatientId(generateUniqueEntityIds.generateUniqueEntityId());
        clinicPatients.setPatientName(clinicPatientsDto.getPatientName());
        clinicPatients.setPatientSurname(clinicPatientsDto.getPatientSurname());
        return Optional.of(clinicPatientsRepository.save(clinicPatients));
    }

    public List<ClinicPatientsDto> listClinicPatients() {

        return clinicPatientsRepository.findAll()
                .stream().map(clinicPatientsDtoConverter::convertAllFields).toList();
    }

    public Optional<ClinicPatients> getClinicPatients(Long patientId) {

        return Optional.ofNullable(clinicPatientsRepository.findByPatientId(patientId));
    }

    public Optional<Integer> updateClinicPatients(Long patientId, ClinicPatientsDto clinicPatientsDto) {

        return clinicPatientsRepository.updatePatientNameByPatientId(patientId, clinicPatientsDto.getPatientName());
    }

    public Optional<Integer> deleteClinicPatients(Long patientId) {

        Optional<Integer> deleteRows = Optional.of(clinicPatientsRepository.deleteClinicPatientByPatientId(patientId));
        clinicAppointmentsRepository.deleteClinicAppointmentByPatientId(patientId);
        return deleteRows;
    }
}
