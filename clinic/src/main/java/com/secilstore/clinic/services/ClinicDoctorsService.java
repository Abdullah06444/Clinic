package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;
    private final ClinicDoctorsRepository clinicDoctorsRepository;

    public ClinicDoctors saveClinicDoctors(ClinicDoctors clinicDoctors) {

        return clinicDoctorsRepository.save(clinicDoctors);
    }

    public List<ClinicDoctorsDto> listClinicDoctors(){

        return clinicDoctorsRepository.findAll()
                .stream().map(clinicDoctorsDtoConverter::convert).toList();
    }
}
