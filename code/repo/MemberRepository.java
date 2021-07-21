package com.example.test.repo;

import org.springframework.stereotype.Repository;
import com.example.test.entity.departEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<departEntity, Long>{
    
}
