package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.entity.rescueEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface rescueRepo extends JpaRepository<rescueEntity, Long>{
    List<rescueEntity> findByResId(String resId);
}
