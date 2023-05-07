package com.musala.drone.repository.domain;

import com.musala.drone.repository.enums.Model;
import com.musala.drone.repository.enums.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DRONE")
public class Drone implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SERIAL_NUMBER")
    @Size(max = 100)
    private String serialNumber;
    @Column(name = "MODEL")
    @Enumerated(EnumType.ORDINAL)
    private Model model;
    @Column(name = "WEIGHT_LIMIT")
    @DecimalMax(value = "500", message = "Maximum 500 grams allowed")
    private Double weightLimit;
    @Column(name = "BATTERY_CAPACITY")
    @DecimalMax(value = "100", message = "Maximum 100%")
    private Double batteryCapacity;
    @Column(name = "STATE")
    @Enumerated(EnumType.ORDINAL)
    private State state;

    @OneToMany(mappedBy = "drone", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Medication> medications;
}