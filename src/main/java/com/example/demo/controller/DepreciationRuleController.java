package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {

    @Autowired
    private DepreciationRuleService service;

    @PostMapping
    public DepreciationRule save(@RequestBody DepreciationRule rule) {
        return service.saveRule(rule);
    }

    @GetMapping
    public List<DepreciationRule> getAll() {
        return service.getAllRules();
    }
}
