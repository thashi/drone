package com.musala.drone.service.impl;

import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.dto.ResponseDto;
import com.musala.drone.service.MedicationService;
import com.musala.drone.service.ServiceUtil;
import com.musala.drone.service.bl.MedicationServiceBL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    public static final Logger LOGGER = LoggerFactory.getLogger(MedicationServiceImpl.class);

    @Autowired
    MedicationServiceBL medicationServiceBL;

    @Autowired
    ServiceUtil serviceUtil;

    @Override
    public ResponseDto createMedication(MedicationDto medicationDto) {
        ResponseDto responseDto = null;
        try {
            MedicationDto m = medicationServiceBL.saveMedication(medicationDto);
            responseDto = serviceUtil.getServiceResponse(m);
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public ResponseDto getAllMedication() {
        ResponseDto responseDto = null;
        try {
            List<MedicationDto> medicationDtos = medicationServiceBL.getAllMedication();
            responseDto = serviceUtil.getServiceResponse(medicationDtos);
        } catch (Exception e){
//            e.printStackTrace();
            LOGGER.info(e.getMessage());
            responseDto = serviceUtil.getErrorServiceResponse(e.getMessage());
        }
        return responseDto;
    }
}
