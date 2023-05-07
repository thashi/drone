package com.musala.drone.service;

import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.dto.ResponseDto;

public interface MedicationService {

    ResponseDto createMedication(MedicationDto medicationDto);

    ResponseDto getAllMedication();
}
