package com.example.demo.controller;

import com.example.demo.entity.DepreciationRuleentity;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {

    private final DepreciationRuleService ruleService;

    public DepreciationRuleController(DepreciationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    // CREATE
    @PostMapping
    public DepreciationRuleentity saveRule(@RequestBody DepreciationRuleentity rule) {
        return ruleService.saveRule(rule);
    }

    // READ ALL
    @GetMapping
    public List<DepreciationRuleentity> getAllRules() {
        return ruleService.getAllRules();
    }
}
