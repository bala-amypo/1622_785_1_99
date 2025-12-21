package com.example.demo.service.Impl;
import com.example.demo.entity.DepreciationRuleentity;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {

    @Autowired
    private DepreciationRuleRepository ruleRepository;

    @Override
    public DepreciationRuleentity saveRule(DepreciationRuleentity rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public List<DepreciationRuleentity> getAllRules() {
        return ruleRepository.findAll();
    }
}
