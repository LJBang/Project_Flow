package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.cpEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface cpRepo extends JpaRepository<cpEntity, Long>{
    Integer countByCpState(String cpState);
    Integer countByCpRegion(String cpRegion);
    Integer countByCpPurpose(String cpPurpose);
}
