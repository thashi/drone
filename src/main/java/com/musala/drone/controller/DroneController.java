package com.musala.drone.controller;

import com.musala.drone.repository.dto.DroneDto;
import com.musala.drone.repository.dto.ResponseDto;
import com.musala.drone.repository.enums.State;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping
    public ResponseDto createDrone(@RequestBody DroneDto droneDto) {
        return droneService.createDrone(droneDto);
    }

    @GetMapping
    public ResponseDto getAllDrones() {
        return droneService.getAllDrones();
    }

    @PutMapping("/{id}")
    public ResponseDto loadMedication(@PathVariable Long id, @RequestBody DroneDto droneDto) {
        return droneService.loadMedication(id, droneDto);
    }

    @GetMapping("/loaded")
    public ResponseDto getLoadedMedication(@RequestParam String serial) {
        return droneService.getLoadedMedication(serial);
    }

    @GetMapping("/filter")
    public ResponseDto getDronesByState(@RequestParam State state) {
        return droneService.getDroneByState(state);
    }
}
