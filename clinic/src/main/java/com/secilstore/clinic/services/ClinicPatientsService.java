package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicPatientsDtoConverter;
import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClinicPatientsService {

    private final ClinicPatientsDtoConverter clinicPatientsDtoConverter;
    private final ClinicPatientsRepository clinicPatientsRepository;

    public ClinicPatients saveClinicPatients(ClinicPatients clinicPatients) {

        return clinicPatientsRepository.save(clinicPatients);
    }

    public List<ClinicPatientsDto> listClinicPatients() {

        return clinicPatientsRepository.findAll()
                .stream().map(clinicPatientsDtoConverter::convert).toList();
    }
}
