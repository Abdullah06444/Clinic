package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;
    private final ClinicDoctorsRepository clinicDoctorsRepository;

    public ClinicDoctors saveClinicDoctors(ClinicDoctors clinicDoctors) {

        return clinicDoctorsRepository.save(clinicDoctors); //id aynı olursa 500 hatasına birşey dön
    }

    public List<ClinicDoctorsDto> listClinicDoctors() {

        return clinicDoctorsRepository.findAll()
                .stream().map(clinicDoctorsDtoConverter::convertAllFields).toList();
    }

    public ClinicDoctors getClinicDoctors(Long doctorId) {

        return clinicDoctorsRepository.findByDoctorId(doctorId);//clinicAppointmentList bak, eksik fieldleri ekle // olmayan id de dönen hata orElse(null) ile kapatılmış
    }

    public ClinicDoctors updateClinicDoctors(Long doctorId, ClinicDoctors updateClinicDoctors) {
        Optional<ClinicDoctors> getClinicDoctors = Optional.ofNullable(this.getClinicDoctors(doctorId));
        if(getClinicDoctors.isPresent()){
            ClinicDoctors foundClinicDoctors = getClinicDoctors.get();
            foundClinicDoctors.setDoctorPerHourFee(updateClinicDoctors.getDoctorPerHourFee());
            return this.saveClinicDoctors(foundClinicDoctors);
        }
        return null;
    }

    public void deleteClinicDoctors(Long doctorId) {

        clinicDoctorsRepository.deleteByDoctorId(doctorId);//doktor yoksa bulunamadı diye uyarı göster
    }
}
