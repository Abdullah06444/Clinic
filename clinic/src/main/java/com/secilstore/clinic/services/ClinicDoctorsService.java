package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicDoctors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;

    public List<ClinicDoctorsDto> list(){

        List<ClinicDoctorsDto> clinicDoctorsDtoList = new LinkedList<>();

        ClinicDoctors clinicDoctors = new ClinicDoctors();
        clinicDoctors.setId(Long.valueOf("4"));
        clinicDoctors.setDoctorId(Long.valueOf("52654"));
        clinicDoctors.setDoctorName("Haydar");
        clinicDoctors.setDoctorSurname("Eliaçık");
        clinicDoctors.setDoctorPerHourFee(Double.valueOf("300.02"));

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors));

        ClinicDoctors clinicDoctors2 = new ClinicDoctors();
        clinicDoctors2.setId(Long.valueOf("5"));
        clinicDoctors2.setDoctorId(Long.valueOf("58845"));
        clinicDoctors2.setDoctorName("Elif");
        clinicDoctors2.setDoctorSurname("Tokgöz");
        clinicDoctors2.setDoctorPerHourFee(Double.valueOf("420.22"));

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors2));

        ClinicDoctors clinicDoctors3 = new ClinicDoctors();
        clinicDoctors3.setId(Long.valueOf("6"));
        clinicDoctors3.setDoctorId(Long.valueOf("76500"));
        clinicDoctors3.setDoctorName("Berkan");
        clinicDoctors3.setDoctorSurname("Karagöz");
        clinicDoctors3.setDoctorPerHourFee(Double.valueOf("326.00"));

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors3));

        return clinicDoctorsDtoList;
    }
}
