package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class rescueDTO {
    private String resId;           // 인명구조 정보 고유 id
    private Integer rescued;        // 구조
    private Integer missing;        // 실종
    private Integer injured;        // 부상
    private Integer death;          // 사망
    private Integer returned;       // 귀가
    private Integer unidentified;   // 미확인
    private Integer etc;
}
