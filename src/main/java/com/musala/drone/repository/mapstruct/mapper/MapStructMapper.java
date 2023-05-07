package com.musala.drone.repository.mapstruct.mapper;

import com.musala.drone.repository.domain.Drone;
import com.musala.drone.repository.domain.Medication;
import com.musala.drone.repository.dto.DroneDto;
import com.musala.drone.repository.dto.MedicationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    DroneDto droneToDroneDto(Drone drone);

    Drone droneDtoToDrone(DroneDto droneDto);

    @Mapping(target = "droneId", source = "drone.id")
    MedicationDto medicationToMedicationDto(Medication medication);

    @Mapping(target = "drone.id", source = "medicationDto.droneId")
    Medication medicationDtoToMedication(MedicationDto medicationDto);
}
