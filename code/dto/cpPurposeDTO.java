package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class cpPurposeDTO {
    // 화면 좌측 해양세력 용도 
    private Integer cpSearch;       // 해양세력 용도 - 수색구조
    private Integer cpPrevent;      // 해양세력 용도 - 방제
    private Integer cpGuide;        // 해양세력 용도 - 지도
    private Integer cpCrackdown;    // 해양세력 용도 - 단속
    private Integer cpArrest;       // 해양세력 용도 - 나포
}