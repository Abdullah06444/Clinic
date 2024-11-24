package com.secilstore.clinic.controllers;

import com.secilstore.clinic.entities.ClinicPatients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class ClinicPatientsController {

    @PostMapping
    public ClinicPatients save(@RequestBody ClinicPatients clinicPatients){
        return clinicPatients;
    }
}
