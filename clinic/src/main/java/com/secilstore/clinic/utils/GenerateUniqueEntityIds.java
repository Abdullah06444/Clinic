package com.secilstore.clinic.utils;

import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class GenerateUniqueEntityIds {

    private final ClinicDoctorsRepository clinicDoctorsRepository;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;
    private final ClinicPatientsRepository clinicPatientsRepository;

    public Long generateUniqueEntityId() {

        Set<Long> existingEntityIds = Stream.concat(
                Stream.concat(
                        clinicDoctorsRepository.findAll().stream().map(ClinicDoctors::getDoctorId),
                        clinicPatientsRepository.findAll().stream().map(ClinicPatients::getPatientId)
                ),
                clinicAppointmentsRepository.findAll().stream().map(ClinicAppointments::getAppointmentId)
        ).collect(Collectors.toSet());

        Random random = new Random();
        Long newEntityId;
        do {
            newEntityId = 10000L + random.nextLong(90000L);
        } while (existingEntityIds.contains(newEntityId));

        return newEntityId;
    }
}
