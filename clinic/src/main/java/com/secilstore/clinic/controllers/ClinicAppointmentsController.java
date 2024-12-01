package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicAppointmentsDto;
import com.secilstore.clinic.dto.UpdateClinicAppointmentsDto;
import com.secilstore.clinic.entities.ClinicAppointments;
import com.secilstore.clinic.services.ClinicAppointmentsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class ClinicAppointmentsController {

    private final ClinicAppointmentsService clinicAppointmentsService;

    @PostMapping
    public ClinicAppointments save(@RequestBody ClinicAppointmentsDto clinicAppointmentsDto) {
        return clinicAppointmentsService.saveClinicAppointments(clinicAppointmentsDto);
    }

    @GetMapping("/{appointmentId}")
    public ClinicAppointments get(@PathVariable Long appointmentId){

        return clinicAppointmentsService.getClinicAppointments(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + appointmentId));
    }

    @GetMapping("/list")
    public List<ClinicAppointmentsDto> list(){
        return clinicAppointmentsService.listClinicAppointments();
    }

    @PutMapping("/{appointmentId}")
    public ClinicAppointments update(@PathVariable Long appointmentId, @RequestBody UpdateClinicAppointmentsDto updateClinicAppointmentsDto){
        return clinicAppointmentsService.updateClinicAppointments(appointmentId, updateClinicAppointmentsDto);
    }

    @DeleteMapping("/{appointmentId}")
    public void delete(@PathVariable Long appointmentId){
        clinicAppointmentsService.deleteClinicAppointments(appointmentId);
    }
}
