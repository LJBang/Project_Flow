package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class cpDTO {
    private String cpId;        // 해양세력 고유 Id
    private String cpName;      // 해양세력 선박명
    private String cpPurpose;   // 해양세력 선박 용도
    private String cpRegion;    // 해양세력 소속 권역
    private String cpState;     // 해양세력 현재 상태
    private String cpDetail;    // 해양세력 세부 상태
    private String cpLat;       // 해양세력 선박 위도
    private String cpLon;       // 해양세력 선박 경도
}
