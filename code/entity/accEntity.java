package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="accident")
public class accEntity {
    @Id
    @Column(nullable = false)
    private String accId;

    // 구조 현황과 1:1 관계
    @OneToOne
    @JoinColumn(name="resId")
    private rescueEntity resId;

    // 사고선박과 연계테이블(accship)과 1:N 관계
    @OneToMany(mappedBy = "accId") 
    private List<accshipEntity> accShipId;

    // 출동 경찰과 연계테이블(dispatch)과 1:N 관계
    @OneToMany(mappedBy = "accId")
    private List<dispatchEntity> dispId;

    @Column(nullable = false, length = 30)
    private String accType;

    @Column(nullable = false, length = 30)
    private String accDetail;

    @Column(nullable = false, length = 50)
    private String accCall;

    @Column(nullable = false, length = 50)
    private String accCaller;

    @Column(nullable = false, length = 50)
    private String accSubmit;

    @Column(nullable = false, length = 30)
    private String accState;

    @Column(nullable = false, length = 30)
    private String accLat;

    @Column(nullable = false, length = 30)
    private String accLon;

    @Column(nullable = false, length = 30)
    private String accResp;

    @Column(nullable = false, length = 30)
    //private String accTime;
    private String accTime;

    @Column(nullable = false, length = 30)
    private String accInfo;
}
