package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.dispatchDTO;
import com.example.demo.repo.dispatchRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class dispatchServiceImpl implements dispatchService {
    private final dispatchRepo repo;
    
    // 출동 기록 전체 정보
    @Override
    public List<dispatchDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}