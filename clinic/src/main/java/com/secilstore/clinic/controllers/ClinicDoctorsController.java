package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.services.ClinicDoctorsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/doctor")
public class ClinicDoctorsController {

    private final ClinicDoctorsService clinicDoctorsService;

    @PostMapping
    public ClinicDoctors save(@RequestBody ClinicDoctorsDto clinicDoctorsDto){

        return clinicDoctorsService.saveClinicDoctors(clinicDoctorsDto)
                .orElseThrow(() -> new EntityNotFoundException("Yeni veri kaydedilemedi."));
    }

    @GetMapping("/{doctorId}")
    public ClinicDoctors get(@PathVariable Long doctorId){

        return clinicDoctorsService.getClinicDoctors(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + doctorId + " ile herhangi bir kayıt bulunamadı."));
    }

    @GetMapping("/list")
    public List<ClinicDoctorsDto> list(){

        return clinicDoctorsService.listClinicDoctors()
                .orElseThrow(() -> new EntityNotFoundException("Herhangi bir doktor kaydı bulunamadı."));
    }

    @PutMapping("/{doctorId}")
    public Integer update(@PathVariable Long doctorId, @RequestBody ClinicDoctorsDto clinicDoctorsDto){

        return clinicDoctorsService.updateClinicDoctors(doctorId, clinicDoctorsDto)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + doctorId + " ile herhangi bir kayıt bulunup güncellenmedi."));
    }

    @DeleteMapping("/{doctorId}")
    public Integer delete(@PathVariable Long doctorId){

        return clinicDoctorsService.deleteClinicDoctors(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + doctorId + " ile herhangi bir kayıt bulunup silinemedi."));
    }
}
