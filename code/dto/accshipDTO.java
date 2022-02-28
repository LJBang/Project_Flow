package com.example.demo.dto;

import com.example.demo.entity.accEntity;
import com.example.demo.entity.shipEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class accshipDTO {
    private String accShipId;   // 사고-선박 연결 고유 Id
    private accEntity accId;       // 사고 고유 Id
    private shipEntity shipId;      // 선박 고유 Id
}
