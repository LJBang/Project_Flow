package com.example.demo.controller;

import com.example.demo.service.cpService;
import com.example.demo.service.crackdownService;
import com.example.demo.service.accService;
import com.example.demo.service.dispatchService;
import com.example.demo.service.rescueService;
import com.example.demo.service.shipService;

import java.util.HashMap;
import java.util.List;

import com.example.demo.dto.shipDTO;
import com.example.demo.dto.accDTO;
import com.example.demo.dto.accTypeDTO;
import com.example.demo.dto.cpDTO;
import com.example.demo.dto.cpPurposeDTO;
import com.example.demo.dto.cpRegionDTO;
import com.example.demo.dto.cpStateDTO;
import com.example.demo.dto.crackdownDTO;
import com.example.demo.dto.dispatchDTO;
import com.example.demo.dto.rescueDTO;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@CrossOrigin("*")
public class Controller {
    private final cpService cpserv; 
    private final accService accserv; 
    private final rescueService rescueserv;
    private final dispatchService dispatchserv;
    private final shipService shipserv;
    private final crackdownService crackserv;

    // 모든 배에 대한 정보
    @GetMapping("/ship")
    public HashMap<String, Object> getship(@RequestParam(name="shipid", required = false) String shipId){

        if(shipId != null){
            List<shipDTO> dto = shipserv.getOne(shipId);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(shipId, dto);
            return hashMap;
        }
        else{
            List<shipDTO> list = shipserv.getListAll();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("list", list);
            return hashMap;
        }
    }

    // 모든 해양경찰에 대한 정보
    @GetMapping("/cpolice")
    public HashMap<String, Object> getcp(){
        List<cpDTO> list = cpserv.getListAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("list", list);
        return hashMap;
    }

    // 상황판 좌측 용도별 경찰 수
    @GetMapping("/cpolice/purpose")
    public HashMap<String, Object> getPurpose(){
        cpPurposeDTO dto = cpserv.countByPurpose();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("purpose", dto);
        return hashMap;
    }

    // 상황판 좌측 지역별 경찰 수
    @GetMapping("/cpolice/region")
    public HashMap<String, Object> getRegion(){
        cpRegionDTO dto = cpserv.countByRegion();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("region", dto);
        return hashMap;
    }

    // 상황판 좌측 상태별 경찰 수
    @GetMapping("/cpolice/state")
    public HashMap<String, Object> getState(){
        cpStateDTO dto = cpserv.countByState();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("state", dto);
        return hashMap;
    }

    // 모든 재난 정보
    @GetMapping("/accident")
    public HashMap<String, Object> getAcc(@RequestParam(name="accid", required = false) String accId){
        if(accId != null){
            List<accDTO> dto = accserv.getOne(accId);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("accident", dto);
            return hashMap;
        }
        else{
            List<accDTO> list = accserv.getListAll();
            //List<accEntity> list = repo.findAll(); 
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("list", list);
            return hashMap;
        }
    }

    // 상황판 상단 분류별 재난 수
    @GetMapping("/accident/type")
    public HashMap<String, Object> getType(/*@RequestParam(name="date")String accDate*/){
        accTypeDTO dto = accserv.countByType(/*accDate*/);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("type", dto);
        return hashMap;
    }

    // 재난별 구조인원 정보
    @GetMapping("/rescue")
    public HashMap<String, Object> getRescue(@RequestParam(name="resid") String resId){
        List<rescueDTO> dto = rescueserv.getRescueDTO(resId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rescue", dto);
        return hashMap;
    }

    @GetMapping("/dispatch")
    public HashMap<String, Object> AllDisp(){
        List<dispatchDTO> dto = dispatchserv.getListAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dispatch", dto);
        return hashMap;
    }

    @GetMapping("/crackdownseize")
    public HashMap<String, Object> Allcrack(){
        List<crackdownDTO> dto = crackserv.getListAll();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("crackdownseize", dto);
        return hashMap;
    }
}