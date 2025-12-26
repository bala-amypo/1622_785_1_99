package com.example.demo.service.impl;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {
    @Autowired private DepreciationRuleRepository repo;

    @Override
    public DepreciationRule createRule(DepreciationRule r) {
        if(r.getUsefulLifeYears() <= 0) throw new IllegalArgumentException("Life must be > 0");
        if(r.getSalvageValue() < 0) throw new IllegalArgumentException("Salvage must be >= 0");
        if(!Arrays.asList("STRAIGHT_LINE", "DECLINING_BALANCE").contains(r.getMethod())) 
            throw new IllegalArgumentException("Invalid Method");
            
        return repo.save(r);
    }
    @Override public List<DepreciationRule> getAllRules() { return repo.findAll(); }
}