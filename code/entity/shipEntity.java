package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="ship")
public class shipEntity {
    @Id
    @Column(nullable = false)
    private String shipId;

    @Column(nullable = false, unique = true, length = 30)
    private String shipName;

    @Column(nullable = false, length = 30)
    private String shipOwner;

    @Column(nullable = false, length = 30)
    private String shipPhone;

    @Column(nullable = false, length = 50)
    private String shipTime;

    @Column(nullable = false, length = 50)
    private String shipPurpose;

    @Column(nullable = false, length = 50)
    private String shipPeople;

    @Column(nullable = false, length = 30)
    private String shipLat;

    @Column(nullable = false, length = 30)
    private String shipLon;

    @Column(nullable = false, length = 30)
    private String shipIns;
}
