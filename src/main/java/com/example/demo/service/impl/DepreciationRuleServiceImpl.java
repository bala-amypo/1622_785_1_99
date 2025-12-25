package com.example.demo.service.impl;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {

    private final DepreciationRuleRepository ruleRepository;

    public DepreciationRuleServiceImpl(DepreciationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DepreciationRule saveRule(DepreciationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public DepreciationRule getRuleById(Long id) {
        return ruleRepository.findById(id).orElseThrow();
    }

    @Override
    public DepreciationRule getRuleByName(String name) {
        return ruleRepository.findByRuleName(name).orElseThrow();
    }

    @Override
    public List<DepreciationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
