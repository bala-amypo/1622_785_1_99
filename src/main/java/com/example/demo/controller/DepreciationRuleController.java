package com.example.demo.controller;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Depreciation Rules.
 * Base path: /api/rules
 * Protected by JWT.
 */
@RestController
@RequestMapping("/api/rules")
public class DepreciationRuleController {

    private final DepreciationRuleService ruleService;

    @Autowired
    public DepreciationRuleController(DepreciationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    /**
     * POST /api/rules
     * Create a new depreciation rule.
     * Logic/Validation is handled in DepreciationRuleServiceImpl.
     */
    @PostMapping
    public ResponseEntity<DepreciationRule> createRule(@RequestBody DepreciationRule rule) {
        DepreciationRule createdRule = ruleService.createRule(rule);
        return ResponseEntity.ok(createdRule);
    }

    /**
     * GET /api/rules
     * List all depreciation rules.
     */
    @GetMapping
    public ResponseEntity<List<DepreciationRule>> getAllRules() {
        List<DepreciationRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}