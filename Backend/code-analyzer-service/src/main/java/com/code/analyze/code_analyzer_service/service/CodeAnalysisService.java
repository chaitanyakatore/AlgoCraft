package com.code.analyze.code_analyzer_service.service;

import org.springframework.stereotype.Service;

import com.code.analyze.code_analyzer_service.client.GeminiApiClient;
import com.code.analyze.code_analyzer_service.model.CodeAnalysisRequest;
import com.code.analyze.code_analyzer_service.model.CodeAnalysisResponse;

@Service
public class CodeAnalysisService {
    private final GeminiApiClient geminiApiClient;

    public CodeAnalysisService(GeminiApiClient geminiApiClient){
        this.geminiApiClient = geminiApiClient;
    }

    public CodeAnalysisResponse analyzeCode(String code, String language){
        CodeAnalysisRequest request = new CodeAnalysisRequest(code, language);
        return geminiApiClient.analyzeCode(request);
    }
}
