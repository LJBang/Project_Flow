package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.rescueDTO;
import com.example.demo.repo.rescueRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class rescueServiceImpl implements rescueService {
    private final rescueRepo repo;
    
    // 구조인원 전체 정보
    @Override
    public List<rescueDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    // resID별 구조 인원 정보
    @Override
    public List<rescueDTO> getRescueDTO(String resId){
        return repo.findByResId(resId).stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}