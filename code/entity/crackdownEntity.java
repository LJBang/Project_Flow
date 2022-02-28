package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="crackdownseize")
public class crackdownEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer drinking; //음주단속
    @Column(nullable = false, name = "illegalfishing")
    private Integer illegalFishing; //불법 조업
    @Column(nullable = false, name = "boundaryinvasion")
    private Integer boundaryInvasion; //경게 침범

    @Column(nullable = false)
    private Integer china; //중국 어선
    @Column(nullable = false)
    private Integer japan; //일본 어선
    @Column(nullable = false, name = "northkorea")
    private Integer northKorea; //북한 어선

}
