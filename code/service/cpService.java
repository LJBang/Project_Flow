package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.cpDTO;
import com.example.demo.dto.cpPurposeDTO;
import com.example.demo.dto.cpRegionDTO;
import com.example.demo.dto.cpStateDTO;
import com.example.demo.entity.cpEntity;

public interface cpService {
    List<cpDTO> getListAll();
    cpPurposeDTO countByPurpose(); 
    cpRegionDTO countByRegion();
    cpStateDTO countByState();

    default cpEntity dtoToEntity(cpDTO dto) {
        cpEntity entity = cpEntity.builder()
                .cpId(dto.getCpId())
                .cpName(dto.getCpName())
                .cpPurpose(dto.getCpPurpose())
                .cpRegion(dto.getCpRegion())
                .cpState(dto.getCpState())
                .cpDetail(dto.getCpDetail())
                .cpLat(dto.getCpLat())
                .cpLon(dto.getCpLon())
                .build();
        return entity;
    }

    default cpDTO entityToDTO(cpEntity entity) {
        cpDTO dto = cpDTO.builder()
                .cpId(entity.getCpId())
                .cpName(entity.getCpName())
                .cpPurpose(entity.getCpPurpose())
                .cpRegion(entity.getCpRegion())
                .cpState(entity.getCpState())
                .cpDetail(entity.getCpDetail())
                .cpLat(entity.getCpLat())
                .cpLon(entity.getCpLon())
                .build();
        return dto;
    }
}
