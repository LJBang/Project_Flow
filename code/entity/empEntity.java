package com.example.test.entity;

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
@Entity(name="employee")
public class empEntity {
    @Id
    @Column(nullable = false)
    private int empno;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false, length = 100)
    private String job;

    @Column(nullable = false)
    private String hiredate;

    @Column(nullable = false)
    private Integer salary;

    @Column(nullable = false)
    private Integer comm;

    @Column(nullable = false)
    private Integer deptno;
}
