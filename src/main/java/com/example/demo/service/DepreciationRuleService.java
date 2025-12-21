package com.example.demo.service;
import com.example.demo.entity.DepreciationRuleentity;
import java.util.List;

public interface DepreciationRuleService {
    DepreciationRuleentity saveRule(DepreciationRuleentity rule);
    List<DepreciationRuleentity> getAllRules();
}
