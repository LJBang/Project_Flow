package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class cpRegionDTO {
    // 화면 좌측 해양세력 권역
    private Integer cpCentral;      // 해양세력 권역 - 중부
    private Integer cpEastern;      // 해양세력 권역 - 동해
    private Integer cpWestern;      // 해양세력 권역 - 서해
    private Integer cpSouthern;     // 해양세력 권역 - 남해
    private Integer cpJeju;         // 해양세력 권역 - 제주
}