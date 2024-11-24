package com.secilstore.clinic.services;

import com.secilstore.clinic.entities.ClinicDoctors;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClinicDoctorsService {

    public List<ClinicDoctors> list(){

        List<ClinicDoctors> clinicDoctorsList = new LinkedList<>();

        ClinicDoctors clinicDoctors = new ClinicDoctors();
        clinicDoctors.setId(4);
        clinicDoctors.setDoctorId(52654);
        clinicDoctors.setDoctorName("Haydar");
        clinicDoctors.setDoctorSurname("Eliaçık");
        clinicDoctors.setDoctorPerHourFee(300.02);

        clinicDoctorsList.add(clinicDoctors);

        ClinicDoctors clinicDoctors2 = new ClinicDoctors();
        clinicDoctors2.setId(5);
        clinicDoctors2.setDoctorId(58845);
        clinicDoctors2.setDoctorName("Elif");
        clinicDoctors2.setDoctorSurname("Tokgöz");
        clinicDoctors2.setDoctorPerHourFee(420.22);

        clinicDoctorsList.add(clinicDoctors2);

        ClinicDoctors clinicDoctors3 = new ClinicDoctors();
        clinicDoctors3.setId(6);
        clinicDoctors3.setDoctorId(76500);
        clinicDoctors3.setDoctorName("Berkan");
        clinicDoctors3.setDoctorSurname("Karagöz");
        clinicDoctors3.setDoctorPerHourFee(326.00);

        clinicDoctorsList.add(clinicDoctors3);

        return clinicDoctorsList;
    }
}
