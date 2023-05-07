package com.musala.drone.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MedicationDto implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("code")
    private String code;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("droneId")
    private Long droneId;
}
