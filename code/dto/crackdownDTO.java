package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class crackdownDTO {
    private Integer id;

    private Integer drinking; //음주단속

    private Integer illegalFishing;

    private Integer boundaryInvasion; //경게 침범

    private Integer china; //중국 어선

    private Integer japan; //일본 어선

    private Integer northKorea; //북한 어선
}
