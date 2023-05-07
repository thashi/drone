package com.musala.drone.service.bl;

import com.musala.drone.repository.dao.MedicationDao;
import com.musala.drone.repository.domain.Medication;
import com.musala.drone.repository.dto.MedicationDto;
import com.musala.drone.repository.mapstruct.mapper.MapStructMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationServiceBL {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationServiceBL.class);

    @Autowired
    private MedicationDao medicationDao;

    @Autowired
    private MapStructMapper mapStructMapper;

    public MedicationDto saveMedication(MedicationDto medicationDto) {
        Medication medication = mapStructMapper.medicationDtoToMedication(medicationDto);
        LOGGER.info(medication.toString());
        Medication m = medicationDao.save(medication);
        return mapStructMapper.medicationToMedicationDto(m);
    }

    public List<MedicationDto> getAllMedication() {
        List<MedicationDto> medicationDtos = new ArrayList<>();
        for (Medication m : medicationDao.findAll()) {
            medicationDtos.add(mapStructMapper.medicationToMedicationDto(m));
        }
        return medicationDtos;
    }
}
