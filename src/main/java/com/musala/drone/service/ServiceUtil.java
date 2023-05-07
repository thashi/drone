package com.musala.drone.service;

import com.musala.drone.repository.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ServiceUtil {

    public ResponseDto getServiceResponse(Object responseObject) {
        ResponseDto serviceResponceDto = new ResponseDto();
        serviceResponceDto.setStatus(Boolean.TRUE);
        serviceResponceDto.setResponseDto(responseObject);
        return serviceResponceDto;
    }

    public ResponseDto getErrorServiceResponse(String errorMessage) {
        ResponseDto serviceResponseDto = new ResponseDto();
        serviceResponseDto.setStatus(Boolean.FALSE);
        serviceResponseDto.setErrorDescription(errorMessage);
        return serviceResponseDto;
    }

}
