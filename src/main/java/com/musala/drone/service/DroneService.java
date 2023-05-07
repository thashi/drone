package com.musala.drone.service;

import com.musala.drone.repository.dto.DroneDto;
import com.musala.drone.repository.dto.ResponseDto;
import com.musala.drone.repository.enums.State;

public interface DroneService {

    ResponseDto createDrone(DroneDto droneDto);

    ResponseDto getAllDrones();

    ResponseDto loadMedication(Long id, DroneDto droneDto);

    ResponseDto getLoadedMedication(String serial);

    ResponseDto getDroneByState(State state);
}
