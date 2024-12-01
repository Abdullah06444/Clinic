package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicPatientsDtoConverter;
import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicPatientsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClinicPatientsService {

    private final ClinicPatientsDtoConverter clinicPatientsDtoConverter;
    private final ClinicPatientsRepository clinicPatientsRepository;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;

    public ClinicPatients saveClinicPatients(ClinicPatients clinicPatients) {

        return clinicPatientsRepository.save(clinicPatients);
    }

    public List<ClinicPatientsDto> listClinicPatients() {

        return clinicPatientsRepository.findAll()
                .stream().map(clinicPatientsDtoConverter::convertAllFields).toList();
    }

    public Optional<ClinicPatients> getClinicPatients(Long patientId) {

        return Optional.ofNullable(clinicPatientsRepository.findByPatientId(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + patientId)));
    }

    public ClinicPatients updateClinicPatients(Long patientId, ClinicPatients updateClinicPatients) {

        Optional<ClinicPatients> getClinicPatients = this.getClinicPatients(patientId);
        if(getClinicPatients.isPresent()) {

            ClinicPatients foundClinicPatients = getClinicPatients.get();
            /**
             * foundClinicPatients.setPatientSurname(updateClinicPatients.getPatientSurname());
             * Güncellenecek uygun değeri yok.
             */
            return this.saveClinicPatients(foundClinicPatients);
        }
        return null;
    }

    public void deleteClinicPatients(Long patientId) {

        clinicPatientsRepository.deleteByPatientId(patientId);
    }
}
