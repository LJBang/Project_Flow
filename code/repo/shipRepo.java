package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.entity.shipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface shipRepo extends JpaRepository<shipEntity, Long>{
    List<shipEntity> findByShipId(String shipId);
}