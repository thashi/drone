package com.musala.drone.repository.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEDICATION")
public class Medication implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    @Pattern(regexp = "^[A-Za-z0-9_-]*$", message = "Allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;
    @Column(name = "WEIGHT")
    private Double weight;
    @Column(name = "CODE")
    @Pattern(regexp = "^[A-Z0-9_]", message = "Allowed only upper case letters, underscore and number")
    private String code;
    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DRONE_ID", nullable = true)
    @JsonIgnore
    private Drone drone;

}
