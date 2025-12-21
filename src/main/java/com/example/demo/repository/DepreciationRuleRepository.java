package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DepreciationRuleentity;

@Repository
public interface DepreciationRuleRepository extends JpaRepository<DepreciationRuleentity,Long>{

}