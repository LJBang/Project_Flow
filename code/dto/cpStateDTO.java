package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class cpStateDTO {
    // 화면 좌측 해양세력 상태
    private Integer cpSecurity;     // 해양세력 상태 - 경비
    private Integer cpDispatch;     // 해양세력 상태 - 출동
    private Integer cpAnchor;       // 해양세력 상태 - 정박
    private Integer cpRepair;       // 해양세력 상태 - 수리
}