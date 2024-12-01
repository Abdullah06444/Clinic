package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.services.ClinicPatientsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{patientId}")
    public ClinicPatients get(@PathVariable Long patientId){

        return clinicPatientsService.getClinicPatients(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + patientId));
    }

    @GetMapping("/list")
    public List<ClinicPatientsDto> list(){
        return clinicPatientsService.listClinicPatients();
    }

    @PutMapping("/{patientId}")
    public ClinicPatients update(@PathVariable Long patientId, @RequestBody ClinicPatients updateClinicPatients){
        return clinicPatientsService.updateClinicPatients(patientId, updateClinicPatients);
    }

    @DeleteMapping("/{patientId}")
    public void delete(@PathVariable Long patientId){
        clinicPatientsService.deleteClinicPatients(patientId);
    }
}
