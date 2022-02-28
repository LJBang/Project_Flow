package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.dispatchDTO;
import com.example.demo.entity.dispatchEntity;

public interface dispatchService {
    List<dispatchDTO> getListAll();

    default dispatchEntity dtoToEntity(dispatchDTO dto) {
        dispatchEntity entity = dispatchEntity.builder()
                .dispId(dto.getDispId())
                .accId(dto.getAccId())
                .cpId(dto.getCpId())
                .build();
        return entity;
    }

    default dispatchDTO entityToDTO(dispatchEntity entity) {
        dispatchDTO dto = dispatchDTO.builder()
                .dispId(entity.getDispId())
                .accId(entity.getAccId())
                .cpId(entity.getCpId())
                .build();
        return dto;
    }    
}
