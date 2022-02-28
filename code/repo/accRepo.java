package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.entity.accEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface accRepo extends JpaRepository<accEntity, Long>{
    Integer countByAccTypeLike(String accType);
    List<accEntity> findByAccId(String accId);
    List<accEntity> findByAccStateNotLike(String accType);

    @Query("select count(acc_type) from accident where acc_type like ?1 and acc_time = ?2")
    public Integer countByAccTypeByDate(String acctype, String acctime);

    @Query("select count(acc_id) from accident where acc_time = ?1")
    public Integer countByDay(String acctime);

    @Query("select count(acc_id) from accident where week(acc_time)=week(?1) and year(acc_time) = year(?1)")
    public Integer countByWeek(String acctime);

    @Query("select count(acc_id) from accident where substring(acc_time,1,7) = substring(?1,1,7) and acc_time <= ?1") 
    public Integer countByMonth(String acctime);

    @Query("select count(acc_id) from accident where year(acc_time) = substring(?1, 1,4) and acc_time <= ?1")
    public Integer countByYear(String acctime);
}
