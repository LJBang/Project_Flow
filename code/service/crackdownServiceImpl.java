package com.example.demo.service;

import com.example.demo.dto.crackdownDTO;
import com.example.demo.repo.crackdownRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class crackdownServiceImpl implements crackdownService {
    private final crackdownRepo repo;
    //단속현황





    @Override
    public List<crackdownDTO> getListAll(){
        return repo.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

}
