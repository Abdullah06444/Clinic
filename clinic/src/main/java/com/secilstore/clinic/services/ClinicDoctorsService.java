package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.repositories.ClinicAppointmentsRepository;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;
    private final ClinicDoctorsRepository clinicDoctorsRepository;
    private final ClinicAppointmentsRepository clinicAppointmentsRepository;

    public ClinicDoctors saveClinicDoctors(ClinicDoctors clinicDoctors) {
//id aynı olursa 500 hatasına birşey dön
        return clinicDoctorsRepository.save(clinicDoctors);
    }

    public List<ClinicDoctorsDto> listClinicDoctors() {

        return clinicDoctorsRepository.findAll()
                .stream().map(clinicDoctorsDtoConverter::convertAllFields).toList();
    }

    public Optional<ClinicDoctors> getClinicDoctors(Long doctorId) {
//clinicAppointmentList bak, eksik fieldleri ekle // olmayan id de dönen hata orElse(null) ile kapatılmış
        return Optional.ofNullable(clinicDoctorsRepository.findByDoctorId(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + doctorId)));
    }

    public ClinicDoctors updateClinicDoctors(Long doctorId, ClinicDoctors updateClinicDoctors) {

        Optional<ClinicDoctors> getClinicDoctors = this.getClinicDoctors(doctorId);
        if(getClinicDoctors.isPresent()){

            ClinicDoctors foundClinicDoctors = getClinicDoctors.get();
            foundClinicDoctors.setDoctorPerHourFee(updateClinicDoctors.getDoctorPerHourFee());
            return this.saveClinicDoctors(foundClinicDoctors);
        }
        return null;
    }

    public void deleteClinicDoctors(Long doctorId) {

        clinicDoctorsRepository.deleteByDoctorId(doctorId);
    }
}
