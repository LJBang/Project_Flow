package com.example.demo.repo;

import com.example.demo.entity.crackdownEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface crackdownRepo  extends JpaRepository<crackdownEntity, Integer> {
}
