package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.rescueDTO;
import com.example.demo.entity.rescueEntity;

public interface rescueService {
    List<rescueDTO> getListAll();
    List<rescueDTO> getRescueDTO(String resId);

    default rescueEntity dtoToEntity(rescueDTO dto) {
        rescueEntity entity = rescueEntity.builder()
                .resId(dto.getResId())
                .rescued(dto.getRescued())
                .missing(dto.getMissing())
                .injured(dto.getInjured())
                .death(dto.getDeath())
                .returned(dto.getReturned())
                .unidentified(dto.getUnidentified())
                .etc(dto.getEtc())
                .build();
        return entity;
    }

    default rescueDTO entityToDTO(rescueEntity entity) {
        rescueDTO dto = rescueDTO.builder()
                .resId(entity.getResId())
                .rescued(entity.getRescued())
                .missing(entity.getMissing())
                .injured(entity.getInjured())
                .death(entity.getDeath())
                .returned(entity.getReturned())
                .unidentified(entity.getUnidentified())
                .etc(entity.getEtc())
                .build();
        return dto;
    }    
}
