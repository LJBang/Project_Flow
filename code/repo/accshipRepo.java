package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.accshipEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface accshipRepo extends JpaRepository<accshipEntity, Long>{
    
}