package com.example.test.controller;

import com.example.test.repo.MemberRepository;
import com.example.test.repo.empRepo;

import java.util.List;

import com.example.test.entity.departEntity;
import com.example.test.entity.empEntity;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberController {
    private final MemberRepository memberRepository;
    private final empRepo emprepo;

    @GetMapping("/depart")
    public List<departEntity> findAlldepart(){
        return memberRepository.findAll();
    }

    @GetMapping("/employee")
    public List<empEntity> getEmployee(@RequestParam(name = "name", required = false) String name,
                                        @RequestParam(name = "job", required = false) String job, 
                                        @RequestParam(name = "deptno", required = false) Integer deptno){
        if(name == null && job == null && deptno == null){
            return emprepo.findAll();
        }
        else{
            return emprepo.findByNameOrJobOrDeptno(name, job, deptno);
        }
    }
}
