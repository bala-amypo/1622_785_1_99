package com.example.demo.controller;

import com.example.demo.entity.DepreciationRuleentity;
import com.example.demo.service.DepreciationRuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {

    @Autowired
    private DepreciationRuleService ruleService;

    public DepreciationRuleController(DepreciationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public DepreciationRuleentity saveRule(@Valid @RequestBody DepreciationRuleentity rule) {
        return ruleService.saveRule(rule);
    }

    @GetMapping
    public List<DepreciationRuleentity> getAllRules() {
        return ruleService.getAllRules();
    }
}
