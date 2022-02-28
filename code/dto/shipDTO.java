package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class shipDTO {
    private String shipId;          // 선박 고유 id
    private String shipName;        // 선박 이름
    private String shipOwner;       // 선박주 명
    private String shipPhone;       // 선박 전화번호
    private String shipTime;        // 출항 시간
    private String shipPurpose;     // 출항 목적
    private String shipPeople;      // 탑승 승객 수
    private String shipLat;         // 선박 위치 위도
    private String shipLon;         // 선박 위치 경도
    private String shipIns;         // 보험 유무
}
