package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.shipDTO;
import com.example.demo.entity.shipEntity;

public interface shipService {
    List<shipDTO> getListAll();
    List<shipDTO> getOne(String shipId);

    default shipEntity dtoToEntity(shipDTO dto) {
        shipEntity entity = shipEntity.builder()
                .shipId(dto.getShipId())
                .shipName(dto.getShipName())
                .shipOwner(dto.getShipOwner())
                .shipPhone(dto.getShipPhone())
                .shipTime(dto.getShipTime())
                .shipPurpose(dto.getShipPurpose())
                .shipPeople(dto.getShipPeople())
                .shipLat(dto.getShipLat())
                .shipLon(dto.getShipLon())
                .shipIns(dto.getShipIns())
                .build();
        return entity;
    }

    default shipDTO entityToDTO(shipEntity entity) {
        shipDTO dto = shipDTO.builder()
                .shipId(entity.getShipId())
                .shipName(entity.getShipName())
                .shipOwner(entity.getShipOwner())
                .shipPhone(entity.getShipPhone())
                .shipTime(entity.getShipTime())
                .shipPurpose(entity.getShipPurpose())
                .shipPeople(entity.getShipPeople())
                .shipLat(entity.getShipLat())
                .shipLon(entity.getShipLon())
                .shipIns(entity.getShipIns())
                .build();
        return dto;
    }    
}
