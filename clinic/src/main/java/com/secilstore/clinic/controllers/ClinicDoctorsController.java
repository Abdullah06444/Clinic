package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.services.ClinicDoctorsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/doctor")
public class ClinicDoctorsController {

    private final ClinicDoctorsService clinicDoctorsService;

    @PostMapping
    public ClinicDoctors save(@RequestBody ClinicDoctors clinicDoctors){
        return clinicDoctorsService.saveClinicDoctors(clinicDoctors);
    }

    @GetMapping("/{doctorId}")
    public ClinicDoctors get(@PathVariable Long doctorId){

        return clinicDoctorsService.getClinicDoctors(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + doctorId));
    }

    @GetMapping("/list")
    public List<ClinicDoctorsDto> list(){
        return clinicDoctorsService.listClinicDoctors();
    }

    @PutMapping("/{doctorId}")
    public ClinicDoctors update(@PathVariable Long doctorId, @RequestBody ClinicDoctors updateClinicDoctors){
        return clinicDoctorsService.updateClinicDoctors(doctorId, updateClinicDoctors);
    }

    @DeleteMapping("/{doctorId}")
    public void delete(@PathVariable Long doctorId){
        clinicDoctorsService.deleteClinicDoctors(doctorId); // varsa siler yoksa boş döner
    }
}
