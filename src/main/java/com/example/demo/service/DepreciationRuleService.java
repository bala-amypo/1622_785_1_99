package com.example.demo.service;

import com.example.demo.entity.DepreciationRule;
import java.util.List;

public interface DepreciationRuleService {

    DepreciationRule saveRule(DepreciationRule rule);

    DepreciationRule getRuleById(Long id);

    DepreciationRule getRuleByName(String name);

    List<DepreciationRule> getAllRules();
}
