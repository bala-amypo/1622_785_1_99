package com.example.demo.service.impl;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {

    @Autowired
    private DepreciationRuleRepository repository;

    @Override
    public DepreciationRule saveRule(DepreciationRule rule) {
        if (rule.getUsefulLifeYears() <= 0 || rule.getSalvageValue() < 0) {
            throw new IllegalArgumentException("Invalid depreciation rule");
        }
        return repository.save(rule);
    }

    @Override
    public List<DepreciationRule> getAllRules() {
        return repository.findAll();
    }
}
