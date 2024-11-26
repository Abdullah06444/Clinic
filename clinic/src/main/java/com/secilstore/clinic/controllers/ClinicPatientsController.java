package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.services.ClinicPatientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patient")
public class ClinicPatientsController {

    private final ClinicPatientsService clinicPatientsService;

    @PostMapping
    public ClinicPatients save(@RequestBody ClinicPatients clinicPatients){
        return clinicPatientsService.saveClinicPatients(clinicPatients);
    }

    @GetMapping("/list")
    public List<ClinicPatientsDto> list(){
        return clinicPatientsService.listClinicPatients();
    }
}
