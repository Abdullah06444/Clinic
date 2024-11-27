package com.secilstore.clinic.utils;

import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SequenceInitializer implements CommandLineRunner{

    private final ClinicDoctorsRepository clinicDoctorsRepository;
    private final ClinicPatientsRepository clinicPatientsRepository;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;

    @Override
    public void run(String... args) {

        Integer maxId1 = clinicDoctorsRepository.findMaxId();
        if (maxId1 == null)
            maxId1 = 0;

        clinicDoctorsRepository.createSequenceIfNotExists(maxId1 + 1);

        clinicDoctorsRepository.resetSequence(maxId1 + 1);

        /* **********************************************/
        Integer maxId2 = clinicPatientsRepository.findMaxId();
        if (maxId2 == null)
            maxId2 = 0;

        clinicPatientsRepository.createSequenceIfNotExists(maxId2 + 1);

        clinicPatientsRepository.resetSequence(maxId2 + 1);

        /* **********************************************/
        Integer maxId3 = clinicAppointmentsRepository.findMaxId();
        if (maxId3 == null)
            maxId3 = 0;

        clinicAppointmentsRepository.createSequenceIfNotExists(maxId3 + 1);

        clinicAppointmentsRepository.resetSequence(maxId3 + 1);
    }
}
