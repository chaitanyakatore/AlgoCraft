package com.code.analyze.code_analyzer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.analyze.code_analyzer_service.model.CodeAnalysisRequest;
import com.code.analyze.code_analyzer_service.model.CodeAnalysisResponse;
import com.code.analyze.code_analyzer_service.service.CodeAnalysisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/code")
public class CodeAnalysisController {

    private final CodeAnalysisService codeAnalysisService;

    public CodeAnalysisController(CodeAnalysisService codeAnalysisService) {
        this.codeAnalysisService = codeAnalysisService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<CodeAnalysisResponse> analyzeCode(@RequestBody @Valid CodeAnalysisRequest request) {
        CodeAnalysisResponse response = codeAnalysisService.analyzeCode(request.getCode(), request.getLanguage());
        return ResponseEntity.ok(response);
    }
}
