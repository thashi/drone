package com.musala.drone.repository.dao;

import com.musala.drone.repository.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicationDao extends JpaRepository<Medication, Long>, JpaSpecificationExecutor<Medication> {
}
