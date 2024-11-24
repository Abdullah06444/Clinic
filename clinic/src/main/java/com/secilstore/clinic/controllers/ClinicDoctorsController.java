package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.services.ClinicDoctorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor") // url farklı olması icin, digerleri ile cakismasin diye
public class ClinicDoctorsController {

    final ClinicDoctorsService clinicDoctorsService;

    public ClinicDoctorsController(ClinicDoctorsService clinicDoctorsService) {
        this.clinicDoctorsService = clinicDoctorsService;
    }

    @PostMapping
    public ClinicDoctors save(@RequestBody ClinicDoctors clinicDoctors){
        return clinicDoctors;
    }

    @GetMapping("/list")
    public List<ClinicDoctorsDto> list(){
        return clinicDoctorsService.list();
    }
}
