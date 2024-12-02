package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicPatientsDto;
import com.secilstore.clinic.entities.ClinicPatients;
import com.secilstore.clinic.services.ClinicPatientsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/patient")
public class ClinicPatientsController {

    private final ClinicPatientsService clinicPatientsService;

    @PostMapping
    public ClinicPatients save(@RequestBody ClinicPatientsDto clinicPatientsDto){
        return clinicPatientsService.saveClinicPatients(clinicPatientsDto)
                .orElseThrow(() -> new EntityNotFoundException("Yeni veri kaydedilemedi."));
    }

    @GetMapping("/{patientId}")
    public ClinicPatients get(@PathVariable Long patientId){

        return clinicPatientsService.getClinicPatients(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + patientId + " ile herhangi bir kayıt bulunamadı."));
    }

    @GetMapping("/list")
    public List<ClinicPatientsDto> list(){
        return clinicPatientsService.listClinicPatients();
    }

    @PutMapping("/{patientId}")
    public Integer update(@PathVariable Long patientId, @RequestBody ClinicPatientsDto clinicPatientsDto){
        return clinicPatientsService.updateClinicPatients(patientId, clinicPatientsDto)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + patientId + " ile herhangi bir kayıt bulunup güncellenmedi."));
    }

    @DeleteMapping("/{patientId}")
    public Integer delete(@PathVariable Long patientId){

        return clinicPatientsService.deleteClinicPatients(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + patientId + " ile herhangi bir kayıt bulunup silinemedi."));
    }
}
