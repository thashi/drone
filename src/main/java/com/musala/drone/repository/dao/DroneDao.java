package com.musala.drone.repository.dao;

import com.musala.drone.repository.domain.Drone;
import com.musala.drone.repository.enums.State;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DroneDao extends JpaRepository<Drone, Long>, JpaSpecificationExecutor<Drone> {

    static Specification<Drone> serialEquals(String serial) {
        return (drone, cq, cb) -> cb.equal(drone.get("serialNumber"), serial);
    }

    static Specification<Drone> hasState(State state) {
        return (drone, cq, cb) -> cb.equal(drone.get("state"), state);
    }

}
