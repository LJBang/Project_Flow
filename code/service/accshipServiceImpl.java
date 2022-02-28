package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.accshipDTO;
import com.example.demo.repo.accshipRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class accshipServiceImpl implements accshipService {
    private final accshipRepo repo;
    
    // 사고선박 연계 테이블 전체 정보
    @Override
    public List<accshipDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
