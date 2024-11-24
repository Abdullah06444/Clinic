package com.secilstore.clinic.services;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.dto.ClinicDoctorsDtoConverter;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.repositories.ClinicDoctorsRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClinicDoctorsService {

    private final ClinicDoctorsDtoConverter clinicDoctorsDtoConverter;
    private final ClinicDoctorsRepository clinicDoctorsRepository;

    public ClinicDoctorsService(ClinicDoctorsDtoConverter clinicDoctorsDtoConverter, ClinicDoctorsRepository clinicDoctorsRepository) {
        this.clinicDoctorsDtoConverter = clinicDoctorsDtoConverter;
        this.clinicDoctorsRepository = clinicDoctorsRepository;
    }

    public List<ClinicDoctorsDto> saveClinicDoctors(ClinicDoctors clinicDoctors) {

        List<ClinicDoctorsDto> clinicDoctorsDtoResult = new LinkedList<>();

        clinicDoctorsRepository.save(clinicDoctors);

        return  clinicDoctorsDtoResult;
    }

    public List<ClinicDoctorsDto> list(){

        List<ClinicDoctorsDto> clinicDoctorsDtoList = new LinkedList<>();

        ClinicDoctors clinicDoctors = new ClinicDoctors();
        clinicDoctors.setId(4);
        clinicDoctors.setDoctorId(52654);
        clinicDoctors.setDoctorName("Haydar");
        clinicDoctors.setDoctorSurname("Eliaçık");
        clinicDoctors.setDoctorPerHourFee(300.02);

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors));

        ClinicDoctors clinicDoctors2 = new ClinicDoctors();
        clinicDoctors2.setId(5);
        clinicDoctors2.setDoctorId(58845);
        clinicDoctors2.setDoctorName("Elif");
        clinicDoctors2.setDoctorSurname("Tokgöz");
        clinicDoctors2.setDoctorPerHourFee(420.22);

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors2));

        ClinicDoctors clinicDoctors3 = new ClinicDoctors();
        clinicDoctors3.setId(6);
        clinicDoctors3.setDoctorId(76500);
        clinicDoctors3.setDoctorName("Berkan");
        clinicDoctors3.setDoctorSurname("Karagöz");
        clinicDoctors3.setDoctorPerHourFee(326.00);

        clinicDoctorsDtoList.add(clinicDoctorsDtoConverter.convert(clinicDoctors3));

        return clinicDoctorsDtoList;
    }
}
