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
@Entity(name="dispatch")
@JsonIgnoreProperties("accId")
public class dispatchEntity {
    @Id
    @Column(nullable = false)
    private String dispId;

    // 재난 엔티티와 N:1
    @ManyToOne
    @JoinColumn(name="accId")
    private accEntity accId;

    // 출동 경찰 엔티티와 N:1
    @ManyToOne
    @JoinColumn(name="cpId")
    private cpEntity cpId;
}
