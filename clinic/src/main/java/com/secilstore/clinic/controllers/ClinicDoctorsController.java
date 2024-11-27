package com.secilstore.clinic.controllers;

import com.secilstore.clinic.dto.ClinicDoctorsDto;
import com.secilstore.clinic.entities.ClinicDoctors;
import com.secilstore.clinic.services.ClinicDoctorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<ClinicDoctors> getClinicDoctors = Optional.ofNullable(clinicDoctorsService.getClinicDoctors(doctorId));
        return getClinicDoctors.orElse(null);
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
