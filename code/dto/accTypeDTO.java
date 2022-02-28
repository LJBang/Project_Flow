package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class accTypeDTO {
    // 상황판 상단 재난 분류별 건수
    private Integer accAccident;    // 해양사고
    private Integer accPolution;    // 해양오염
    private Integer accOrder;       // 해상치안
    private Integer accSecurity;    // 해상보안
    private Integer accComplaint;   // 해양민원
    private Integer accPerDay;      // 일간
    private Integer accPerWeek;     // 주간 -> 미구현..
    private Integer accPerMonth;    // 월간
    private Integer accPerYear;     // 연간
}
