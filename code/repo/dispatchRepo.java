package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.dispatchEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface dispatchRepo extends JpaRepository<dispatchEntity, Long>{
    
}
