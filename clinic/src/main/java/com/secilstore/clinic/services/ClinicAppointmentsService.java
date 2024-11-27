package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.dto.ClinicAppointmentsDtoConverter;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
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

    public ClinicAppointments saveClinicAppointments(ClinicAppointmentsDto clinicAppointmentsDto) {

        Optional<ClinicDoctors> foundClinicDoctors = Optional.ofNullable(clinicDoctorsService.getClinicDoctors(clinicAppointmentsDto.getClinicDoctorId()));
        //Optional<ClinicPatients> foundClinicPatients = Optional.ofNullable(clinicPatientsService.getClinicPatients(clinicAppointmentsDto.getClinicPatientId()));
        if(foundClinicDoctors.isPresent()/* && foundClinicPatients.isPresent()*/) {

            ClinicAppointments saveClinicAppointments = new ClinicAppointments();
            saveClinicAppointments.setClinicDoctors(foundClinicDoctors.get());
            //saveClinicAppointments.setClinicPatients(foundClinicPatients.get());
            saveClinicAppointments.setAppointmentStartDate(clinicAppointmentsDto.getAppointmentStartDate());
            saveClinicAppointments.setAppointmentEndDate(clinicAppointmentsDto.getAppointmentEndDate());

            return clinicAppointmentsRepository.save(saveClinicAppointments);
        }
        return null;
    }

    public List<ClinicAppointmentsDto> listClinicAppointments() {

        return clinicAppointmentsRepository.findAll()
                .stream().map(clinicAppointment -> {
                    ClinicDoctors clinicDoctors = clinicAppointment.getClinicDoctors();
                    ClinicPatients clinicPatients = clinicAppointment.getClinicPatients();

                    return clinicAppointmentsDtoConverter.convert(clinicAppointment, clinicDoctors.getDoctorId(), clinicPatients.getPatientId());
                }).toList();
    }
}
