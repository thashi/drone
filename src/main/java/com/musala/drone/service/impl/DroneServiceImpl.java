package com.musala.drone.service.impl;

import com.musala.drone.repository.dto.DroneDto;
import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.dto.ResponseDto;
import com.musala.drone.repository.enums.State;
import com.musala.drone.service.DroneService;
import com.musala.drone.service.ServiceUtil;
import com.musala.drone.service.bl.DroneServiceBL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {

    public static final Logger LOGGER = LoggerFactory.getLogger(DroneServiceImpl.class);

    @Autowired
    DroneServiceBL droneServiceBL;

    @Autowired
    ServiceUtil serviceUtil;

    @Override
    public ResponseDto createDrone(DroneDto droneDto) {
        ResponseDto responseDto = null;
        try {
            DroneDto d = droneServiceBL.saveDrone(droneDto);
            LOGGER.info(d.toString());
            responseDto = serviceUtil.getServiceResponse(d);
        } catch (Exception e){
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto getAllDrones() {
        ResponseDto responseDto = null;
        try {
            List<DroneDto> droneDtos = droneServiceBL.getAllDrones();
            LOGGER.info("Total number of Drones : " + droneDtos.size());
            responseDto = serviceUtil.getServiceResponse(droneDtos);
        } catch (Exception e){
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto loadMedication(Long id, DroneDto droneDto) {
        ResponseDto responseDto = null;
        try {
            DroneDto d = droneServiceBL.loadMedication(id, droneDto);
            LOGGER.info(d.toString());
            responseDto = serviceUtil.getServiceResponse(d);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto getLoadedMedication(String serial) {
        ResponseDto responseDto = null;
        try {
            List<MedicationDto> medicationDtos = droneServiceBL.getLoadedMedication(serial);
            LOGGER.info("Number of medications loaded : " + medicationDtos.size());
            responseDto = serviceUtil.getServiceResponse(medicationDtos);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto getDroneByState(State state) {
        ResponseDto responseDto = null;
        try {
            List<DroneDto> droneDtos = droneServiceBL.getDronesByState(state);
            LOGGER.info("Found " + droneDtos.size() + " in " + state.name() + " state");
            responseDto = serviceUtil.getServiceResponse(droneDtos);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }
}
