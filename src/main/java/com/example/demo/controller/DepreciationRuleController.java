package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {
    private final DepreciationRuleService service;
    public DepreciationRuleController(DepreciationRuleService s) { this.service = s; }
    @PostMapping public DepreciationRule create(@RequestBody DepreciationRule r) { return service.createRule(r); }
    @GetMapping public List<DepreciationRule> list() { return service.getAllRules(); }
}