package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.accshipDTO;
import com.example.demo.entity.accshipEntity;

public interface accshipService {
    List<accshipDTO> getListAll();

    default accshipEntity dtoToEntity(accshipDTO dto) {
        accshipEntity entity = accshipEntity.builder()
                .accShipId(dto.getAccShipId())
                .shipId(dto.getShipId())
                .build();
        return entity;
    }

    default accshipDTO entityToDTO(accshipEntity entity) {
        accshipDTO dto = accshipDTO.builder()
                .accShipId(entity.getAccShipId())
                .shipId(entity.getShipId())
                .build();
        return dto;
    }
}
