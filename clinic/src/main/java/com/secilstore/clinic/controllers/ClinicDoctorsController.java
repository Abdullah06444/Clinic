package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.services.ClinicDoctorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/doctor") // url farklı olması icin, digerleri ile cakismasin diye
public class ClinicDoctorsController {

    private final ClinicDoctorsService clinicDoctorsService;

    @PostMapping
    public ClinicDoctors save(@RequestBody ClinicDoctors clinicDoctors){
        return clinicDoctorsService.saveClinicDoctors(clinicDoctors);
    }

    @GetMapping("/list")
    public List<ClinicDoctorsDto> list(){
        return clinicDoctorsService.list();
    }
}
