package com.example.demo.service.impl;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {
    private final DepreciationRuleRepository repo;

    public DepreciationRuleServiceImpl(DepreciationRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public DepreciationRule createRule(DepreciationRule r) {
        // PDF Rule 2.5 & 6.3
        if (r.getUsefulLifeYears() == null || r.getUsefulLifeYears() <= 0) 
            throw new IllegalArgumentException("Useful life must be > 0");
        if (r.getSalvageValue() == null || r.getSalvageValue() < 0) 
            throw new IllegalArgumentException("Salvage value must be >= 0");
        if (!"STRAIGHT_LINE".equals(r.getMethod()) && !"DECLINING_BALANCE".equals(r.getMethod()))
            throw new IllegalArgumentException("Invalid method");
        
        return repo.save(r);
    }

    @Override
    public List<DepreciationRule> getAllRules() {
        return repo.findAll();
    }
}