package com.musala.drone.controller;

import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.dto.ResponseDto;
import com.musala.drone.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    @Autowired
    MedicationService medicationService;

    @GetMapping
    public ResponseDto getAllMedication() {
        return medicationService.getAllMedication();
    }

//    @PostMapping
//    public ResponseDto createMedication(@RequestBody MedicationDto medicationDto) {
//        return medicationService.createMedication(medicationDto);
//    }
}
