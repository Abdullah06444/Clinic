package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import com.secilstore.clinic.utils.GenerateUniqueEntityIds;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;
    private final ClinicDoctorsRepository clinicDoctorsRepository;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;
    private final ClinicPatientsRepository clinicPatientsRepository;
    private final GenerateUniqueEntityIds generateUniqueEntityIds;

    public Optional<ClinicDoctors> saveClinicDoctors(ClinicDoctorsDto clinicDoctorsDto) {

        ClinicDoctors clinicDoctors = new ClinicDoctors();
        clinicDoctors.setDoctorId(generateUniqueEntityIds.generateUniqueEntityId());
        clinicDoctors.setDoctorName(clinicDoctorsDto.getDoctorName());
        clinicDoctors.setDoctorSurname(clinicDoctorsDto.getDoctorSurname());
        clinicDoctors.setDoctorPerHourFee(clinicDoctorsDto.getDoctorPerHourFee());
        return Optional.of(clinicDoctorsRepository.save(clinicDoctors));
    }

    public Optional<List<ClinicDoctorsDto>> listClinicDoctors() {

        return Optional.of(clinicDoctorsRepository.findAll()
                .stream().map(clinicDoctorsDtoConverter::convertAllFields).toList());
    }

    public Optional<ClinicDoctors> getClinicDoctors(Long doctorId) {

        return Optional.ofNullable(clinicDoctorsRepository.findByDoctorId(doctorId));
    }

    public Optional<Integer> updateClinicDoctors(Long doctorId, ClinicDoctorsDto clinicDoctorsDto) {

        return clinicDoctorsRepository.updateDoctorPerHourFeeByDoctorId(doctorId, clinicDoctorsDto.getDoctorPerHourFee());
    }

    public Optional<Integer> deleteClinicDoctors(Long doctorId) {

        Optional<Integer> clinicDoctors = Optional.ofNullable(clinicDoctorsRepository.deleteClinicDoctorByDoctorId(doctorId));
        clinicAppointmentsRepository.deleteClinicAppointmentsByDoctorId(doctorId);
        return clinicDoctors;
    }
}
