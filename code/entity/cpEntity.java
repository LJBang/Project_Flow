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
@Entity(name="cpolice")
public class cpEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String cpId;

    @Column(nullable = false)
    private String cpName;

    @Column(nullable = false, length = 100)
    private String cpPurpose;

    @Column(nullable = false)
    private String cpRegion;

    @Column(nullable = false)
    private String cpState;

    @Column(nullable = false)
    private String cpDetail;

    @Column(nullable = false)
    private String cpLat;

    @Column(nullable = false)
    private String cpLon;
}
