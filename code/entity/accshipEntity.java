package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="accship")
@JsonIgnoreProperties("accId")
public class accshipEntity {
    @Id
    @Column(nullable = false)
    private String accShipId;

    // 재난 엔티티와 N:1
    @ManyToOne
    @JoinColumn(name="accId")
    private accEntity accId;

    // 사고 선박 엔티티와 N:1
    @ManyToOne
    @JoinColumn(name="shipId")
    private shipEntity shipId;
}
