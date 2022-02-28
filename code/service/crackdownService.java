package com.example.demo.service;

import com.example.demo.dto.crackdownDTO;
import com.example.demo.entity.crackdownEntity;

import java.util.List;

public interface crackdownService {

    List<crackdownDTO> getListAll();


    default crackdownEntity dtoToEntity(crackdownDTO dto) {
       crackdownEntity entity = crackdownEntity.builder()
               .drinking(dto.getDrinking())
               .illegalFishing(dto.getIllegalFishing())
               .boundaryInvasion(dto.getBoundaryInvasion())
               .china(dto.getChina())
               .japan(dto.getJapan())
               .northKorea(dto.getNorthKorea())
               .build();
        return entity;
    }

    default crackdownDTO entityToDTO(crackdownEntity entity) {
        crackdownDTO dto = crackdownDTO.builder()
                .drinking(entity.getDrinking())
                .illegalFishing(entity.getIllegalFishing())
                .boundaryInvasion(entity.getBoundaryInvasion())
                .china(entity.getChina())
                .japan(entity.getJapan())
                .northKorea(entity.getNorthKorea())
                .build();
        return dto;
    }
}
