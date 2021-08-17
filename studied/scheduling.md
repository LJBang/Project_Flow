# Spring에서의 Scheduling  
스프링 서버에서 특정 작업을 주기적으로 실행시켜야 하는 경우가 있다.  
이번 프로젝트에서는 주기적으로 배가 이동하는 DB에뮬레이터를 표현하려고 했다.  

## 설정
스케쥴링을 사용하기 위해서 스프링부트 실행 파일에 어노테이션을 추가해준다.  
```java
package com.example.emulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   // 스케쥴링을 사용하기위한 어노테이션 
public class EmulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmulatorApplication.class, args);
	}

}
```  

## 구현
스케줄링용 패키지를 따로 만들어 관리한다.  
메서드를 구현하고 `@Scheduled`어노테이션을 추가하면 된다.  
`@Scheduled`부여받은 메소드는 파라미터를 받을수 없고, void형으로 만들어야 한다.  

```java
package com.example.emulator.scheduler;

import java.math.BigDecimal;
import java.util.List;

import com.example.emulator.dto.cpDTO;
import com.example.emulator.service.cpService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class emul {
    private final cpService cpserv;
    @Scheduled(fixedDelay = 60000)
    public void moveShip() {
        List<cpDTO> cp = cpserv.getCpDTO();
        for(cpDTO dto : cp){
            BigDecimal lat_temp = new BigDecimal(dto.getCpLat());
            BigDecimal lon_temp = new BigDecimal(dto.getCpLon());
            BigDecimal b = new BigDecimal("0.001");

            lat_temp = lat_temp.add(b);
            log.info(dto.getCpId() + " lat_temp: " + lat_temp.toString());
            dto.setCpLat(lat_temp.toString());
            
            lon_temp = lon_temp.add(b);
            log.info(dto.getCpId() + " lon_temp: " + lon_temp.toString());
            dto.setCpLon(lon_temp.toString());

            cpserv.saveEn(dto);
        }
    }
}
```  
위 코드의 경우 `moveShip()`메소드가 `60000ms`즉 60초마다 한번씩 실행되는 코드이다.  
실행시키고 싶은 메서드를 자유롭게 작성하면 된다.  

## 스케쥴링 옵션
스케쥴링 옵션을 통해 시간(주기)을 설정해줄수 있다.

- `fixedrate`: 메서드와 상관없이 입력받은 값만큼 고정된 시간마다 실행 (`ms`단위)
- `fixedDelay`: 메서드의 끝을 기준으로 입력받은 값만큼 고정된 시간마다 실행 (`ms`단위)
- `initialDelay`: 실행시 초기 딜레이 (`ms`단위, 기본값 0)
- `cron`: 리눅스 환경의 `cron`과 같은 형태로 주기 설정 가능 (초 분 시 일 월 요일 연도)
- `zone`: cron 설정시 사용할 `timezone`  

