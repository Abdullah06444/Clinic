package com.secilstore.clinic.controllers;

import com.secilstore.clinic.entities.ClinicAppointments;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class ClinicAppointmentsController {

    @PostMapping
    public ClinicAppointments save(@RequestBody ClinicAppointments clinicAppointments){
        return clinicAppointments;
    }
}
