package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.accDTO;
import com.example.demo.dto.accTypeDTO;
import com.example.demo.entity.accEntity;

public interface accService {
    List<accDTO> getListAll();
    accTypeDTO countByType(/*String accDate*/);
    List<accDTO> getOne(String accId);


    default accEntity dtoToEntity(accDTO dto) {
        accEntity entity = accEntity.builder()
                .accId(dto.getAccId())
                .resId(dto.getResId())
                .accType(dto.getAccType())
                .accDetail(dto.getAccDetail())
                .accCall(dto.getAccCall())
                .accCaller(dto.getAccCaller())
                .accSubmit(dto.getAccSubmit())
                .accState(dto.getAccState())
                .accLat(dto.getAccLat())
                .accLon(dto.getAccLon())
                .accResp(dto.getAccResp())
                .accTime(dto.getAccTime())
                .accInfo(dto.getAccInfo())
                .accShipId(dto.getAccShipId())
                .dispId(dto.getDispId())
                .build();
        return entity;
    }

    default accDTO entityToDTO(accEntity entity) {
        accDTO dto = accDTO.builder()
                .accId(entity.getAccId())
                .resId(entity.getResId())
                .accType(entity.getAccType())
                .accDetail(entity.getAccDetail())
                .accCall(entity.getAccCall())
                .accCaller(entity.getAccCaller())
                .accSubmit(entity.getAccSubmit())
                .accState(entity.getAccState())
                .accLat(entity.getAccLat())
                .accLon(entity.getAccLon())
                .accResp(entity.getAccResp())
                .accTime(entity.getAccTime())
                .accInfo(entity.getAccInfo())
                .accShipId(entity.getAccShipId())
                .dispId(entity.getDispId())
                .build();
        return dto;
    }
}
