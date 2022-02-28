package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.accDTO;
import com.example.demo.dto.accTypeDTO;
import com.example.demo.repo.accRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class accServiceImpl implements accService {
    private final accRepo repo;

    // 해양사고 분류별 count 
    @Override
    public accTypeDTO countByType(/*String accDate*/){
        //LocalDate accDates = LocalDate.parse(accDate);
        LocalDate accDates = LocalDate.now();
        String dateStr = accDates.toString();
        //Date accDates = new Date();
        accTypeDTO dto = accTypeDTO.builder()
            .accAccident(repo.countByAccTypeByDate("%사고", dateStr))
            .accPolution(repo.countByAccTypeByDate("%오염", dateStr))
            .accOrder(repo.countByAccTypeByDate("%치안", dateStr))
            .accSecurity(repo.countByAccTypeByDate("%안보", dateStr))
            .accComplaint(repo.countByAccTypeByDate("%민원", dateStr))
            .accPerDay(repo.countByDay(dateStr))
            .accPerWeek(repo.countByWeek(dateStr))
            .accPerMonth(repo.countByMonth(dateStr))
            .accPerYear(repo.countByYear(dateStr))
            .build();
        return dto;
    }

    // 해양사고 전체 
    @Override
    public List<accDTO> getListAll(){
        return repo.findByAccStateNotLike("종료").stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    // accId별 사고 하나
    @Override
    public List<accDTO> getOne(String accId){
        return repo.findByAccId(accId).stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
