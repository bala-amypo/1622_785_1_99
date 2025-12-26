package com.example.demo.repository;

import com.example.demo.entity.DepreciationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * PDF Rule 4.5: Extra method findByRuleName required.
 */
public interface DepreciationRuleRepository extends JpaRepository<DepreciationRule, Long> {
    Optional<DepreciationRule> findByRuleName(String ruleName);
}