package com.example.test.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.test.entity.empEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface empRepo extends JpaRepository<empEntity, Long>{
    List<empEntity> findByNameOrJobOrDeptno(String name, String job, Integer deptno);
    List<empEntity> findByName(String name);
    List<empEntity> findByJob(String Job);
}
