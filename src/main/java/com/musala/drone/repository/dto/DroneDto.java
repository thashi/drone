package com.musala.drone.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drone.repository.enums.Model;
import com.musala.drone.repository.enums.State;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DroneDto implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("model")
    private Model model;
    @JsonProperty("weightLimit")
    private Double weightLimit;
    @JsonProperty("batteryCapacity")
    private Double batteryCapacity;
    @JsonProperty("state")
    private State state;
    @JsonProperty("medications")
    private List<MedicationDto> medicationDtos;
}
