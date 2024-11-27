package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.services.ClinicAppointmentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class ClinicAppointmentsController {

    private final ClinicAppointmentsService clinicAppointmentsService;

    @PostMapping
    public ClinicAppointments save(@RequestBody ClinicAppointments clinicAppointments) {
        return clinicAppointmentsService.saveClinicAppointments(clinicAppointments);
    }

    @GetMapping("/list")
    public List<ClinicAppointmentsDto> list(){
        return clinicAppointmentsService.listClinicAppointments();
    }
}
