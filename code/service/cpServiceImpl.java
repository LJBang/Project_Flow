package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.cpDTO;
import com.example.demo.dto.cpPurposeDTO;
import com.example.demo.dto.cpRegionDTO;
import com.example.demo.dto.cpStateDTO;
import com.example.demo.repo.cpRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class cpServiceImpl implements cpService {
    private final cpRepo repo;

    // 해양세력 용도별 분류
    @Override
    public cpPurposeDTO countByPurpose(){
        cpPurposeDTO dto = cpPurposeDTO.builder()
            .cpSearch(repo.countByCpPurpose("수색구조"))
            .cpPrevent(repo.countByCpPurpose("방제"))
            .cpGuide(repo.countByCpPurpose("지도"))
            .cpCrackdown(repo.countByCpPurpose("단속"))
            .cpArrest(repo.countByCpPurpose("나포"))
            .build();
        return dto;
    }

    // 해양세력 권역별 분류
    @Override
    public cpRegionDTO countByRegion(){
        cpRegionDTO dto = cpRegionDTO.builder()
            .cpCentral(repo.countByCpRegion("중부"))
            .cpWestern(repo.countByCpRegion("서해"))
            .cpEastern(repo.countByCpRegion("동해"))
            .cpSouthern(repo.countByCpRegion("남해"))
            .cpJeju(repo.countByCpRegion("제주"))
            .build();
        return dto;
    }

    // 해양세력 상태별 분류
    @Override
    public cpStateDTO countByState(){
        cpStateDTO dto = cpStateDTO.builder()
            .cpSecurity(repo.countByCpState("경비"))
            .cpDispatch(repo.countByCpState("출동"))
            .cpAnchor(repo.countByCpState("정박"))
            .cpRepair(repo.countByCpState("수리"))
            .build();
        return dto;
    }

    // 해양세력 전체 정보
    @Override
    public List<cpDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
