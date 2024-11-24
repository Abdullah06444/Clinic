package com.secilstore.clinic.dto;

import lombok.Data;

@Data
public class ClinicDoctorsDto {

    private int id;
    private long doctorId;
    private String doctorName;
    private String doctorSurname;
    private double doctorPerHourFee;

    public ClinicDoctorsDto(int id, long doctorId, String doctorName, String doctorSurname, double doctorPerHourFee) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorPerHourFee = doctorPerHourFee;
    }
}
