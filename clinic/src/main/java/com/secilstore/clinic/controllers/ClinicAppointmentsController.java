package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.services.ClinicAppointmentsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class ClinicAppointmentsController {

    private final ClinicAppointmentsService clinicAppointmentsService;

    @PostMapping
    public ClinicAppointments save(@RequestBody ClinicAppointmentsDto clinicAppointmentsDto) {
        return clinicAppointmentsService.saveClinicAppointments(clinicAppointmentsDto)
                .orElseThrow(() -> new EntityNotFoundException("Yeni veri kaydedilemedi."));
    }

    @GetMapping("/{appointmentId}")
    public ClinicAppointments get(@PathVariable Long appointmentId){

        return clinicAppointmentsService.getClinicAppointments(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + appointmentId + " ile herhangi bir kayıt bulunamadı."));
    }

    @GetMapping("/list")
    public List<ClinicAppointmentsDto> list(){
        return clinicAppointmentsService.listClinicAppointments()
                .orElseThrow(() -> new EntityNotFoundException("Herhangi bir randevu kaydı bulunamadı."));
    }

    @PutMapping("/{appointmentId}")
    public Integer update(@PathVariable Long appointmentId, @RequestBody ClinicAppointmentsDto clinicAppointmentsDto){
        return clinicAppointmentsService.updateClinicAppointments(appointmentId, clinicAppointmentsDto)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + appointmentId + " ile herhangi bir kayıt bulunup güncellenmedi."));
    }

    @DeleteMapping("/{appointmentId}")
    public Integer delete(@PathVariable Long appointmentId){
        return clinicAppointmentsService.deleteClinicAppointments(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Bu " + appointmentId + " ile herhangi bir kayıt bulunup silinemedi."));
    }
}
