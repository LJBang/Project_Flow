package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.accshipEntity;
import com.example.demo.entity.dispatchEntity;
import com.example.demo.entity.rescueEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class accDTO {
    private String accId;       // 사고정보 고유 id
    private rescueEntity resId;       // 인명구조 고유 id
    private String accType;     // 사고 분류
    private String accDetail;   // 사고 세분류
    private String accCall;     // 신고 경로
    private String accCaller;   // 신고자
    private String accSubmit;   // 신고 접수 상태
    private String accState;    // 재난 처리 상태
    private String accLat;      // 재난 위도
    private String accLon;      // 재난 경도
    private String accResp;     // 재난 관할
    private String accTime;     // 재난 시간
    private String accInfo;     // 재난 정보
    private List<accshipEntity> accShipId;  // 재난 선박 정보 리스트
    private List<dispatchEntity> dispId;    // 출동 경찰 정보 리스트
}
