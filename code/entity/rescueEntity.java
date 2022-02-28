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
@Entity(name="rescue")
public class rescueEntity {
    @Id
    @Column(nullable = false)
    private String resId;

    @Column(nullable = false)
    private Integer rescued;

    @Column(nullable = false, length = 30)
    private Integer missing; 

    @Column(nullable = false)
    private Integer injured;

    @Column(nullable = false)
    private Integer death;

    @Column(nullable = false, length = 30)
    private Integer returned;

    @Column(nullable = false, length = 30)
    private Integer unidentified;

    @Column(nullable = false, length = 30)
    private Integer etc;
}
