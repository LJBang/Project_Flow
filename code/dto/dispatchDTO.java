package com.example.demo.dto;

import com.example.demo.entity.accEntity;
import com.example.demo.entity.cpEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class dispatchDTO {
    // 해양세력 출동 기록
    private String dispId;  // 출동기록 고유 id
    private accEntity accId;   // 재난 id
    private cpEntity cpId;    // 해양세력 id
}
