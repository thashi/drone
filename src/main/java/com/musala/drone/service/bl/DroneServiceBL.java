package com.musala.drone.service.bl;

import com.musala.drone.repository.dao.DroneDao;
import com.musala.drone.repository.dao.MedicationDao;
import com.musala.drone.repository.domain.Drone;
import com.musala.drone.repository.domain.Medication;
import com.musala.drone.repository.dto.DroneDto;
import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.enums.State;
import com.musala.drone.repository.mapstruct.mapper.MapStructMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.musala.drone.repository.dao.DroneDao.hasState;
import static com.musala.drone.repository.dao.DroneDao.serialEquals;

@Service
@Configuration
@EnableScheduling
public class DroneServiceBL {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroneServiceBL.class);

    @Autowired
    private DroneDao droneDao;

    @Autowired
    private MedicationDao medicationDao;

    @Autowired
    private MapStructMapper mapStructMapper;

    @Transactional
    public DroneDto saveDrone(DroneDto droneDto) {
        Drone drone = mapStructMapper.droneDtoToDrone(droneDto);
        LOGGER.info(drone.toString());
        Drone d = droneDao.save(drone);
        return mapStructMapper.droneToDroneDto(d);
    }

    public List<DroneDto> getAllDrones() {
        List<DroneDto> droneDtos = new ArrayList<>();
        for (Drone d : droneDao.findAll()) {
            droneDtos.add(mapStructMapper.droneToDroneDto(d));
        }
        return droneDtos;
    }

    public DroneDto loadMedication(Long id, DroneDto droneDto) throws Exception {
        Drone drone = droneDao.findById(id).get();

        if (!drone.getState().equals(State.IDLE))
            throw new Exception("Drone is not in idle state");

        if (drone.getBatteryCapacity() < 25)
            throw new Exception("Battery capacity is below 25%");

        Double weight = drone.getMedications().stream().mapToDouble(w -> w.getWeight()).sum();
        LOGGER.info("Drone's existing current weight : " + weight);
        if (drone != null && droneDto.getMedicationDtos() != null) {
            for (MedicationDto m : droneDto.getMedicationDtos()) {
                weight += m.getWeight();
                if (weight <= drone.getWeightLimit()) {
                    Medication me = mapStructMapper.medicationDtoToMedication(m);
                    me.setDrone(drone);
                    LOGGER.info("Drone's updated payload weight : " + weight);
                    medicationDao.save(me);
                } else {
                    throw new Exception("Payload weight exceeding the Drone's weight limit");
                }
            }
        }
        drone.setState(State.LOADING);

        return mapStructMapper.droneToDroneDto(droneDao.save(drone));
    }

    public List<MedicationDto> getLoadedMedication(String serial) throws Exception {
        List<MedicationDto> medicationDtos = new ArrayList<>();
        Specification<Drone> spec = Specification.where(serialEquals(serial));
        List<Drone> drones = droneDao.findAll(spec);
        if (drones != null && !drones.isEmpty()) {
            Drone d = drones.get(0);
            List<Medication> medications = d.getMedications();
            for (Medication m : medications) {
                medicationDtos.add(mapStructMapper.medicationToMedicationDto(m));
            }
        } else {
            throw new Exception("Drone not found for the given serial number!");
        }
        return medicationDtos;
    }


    public List<DroneDto> getDronesByState(State state) throws Exception {
        List<DroneDto> droneDtos = new ArrayList<>();
        Specification<Drone> spec = Specification.where(hasState(state));
        List<Drone> drones = droneDao.findAll(spec);
        if (drones != null && !drones.isEmpty()) {
            for (Drone d : drones) {
                droneDtos.add(mapStructMapper.droneToDroneDto(d));
            }
        } else {
            throw new Exception("Drone(s) not found for the given state!");
        }
        return droneDtos;
    }

    @Scheduled(fixedRate = 100000)
    public void logBatteryLevel() {
        List<Drone> drones = droneDao.findAll();
        for (Drone d : drones) {
            if (!d.getState().equals(State.IDLE))
                LOGGER.info("Drone Serial : " + d.getSerialNumber() + " --- Battery Level : " + d.getBatteryCapacity());
        }
    }
}
