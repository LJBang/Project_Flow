package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.shipDTO;
import com.example.demo.repo.shipRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class shipServiceImpl implements shipService {
    private final shipRepo repo;
    
    // 선박 전체 정보
    @Override
    public List<shipDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    // shipId별 선박 하나 정보
    @Override
    public List<shipDTO> getOne(String shipId){
        return repo.findByShipId(shipId).stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}