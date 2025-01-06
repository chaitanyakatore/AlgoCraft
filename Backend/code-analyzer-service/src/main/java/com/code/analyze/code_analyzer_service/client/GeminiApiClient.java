package com.code.analyze.code_analyzer_service.client;

import com.code.analyze.code_analyzer_service.model.CodeAnalysisRequest;
import com.code.analyze.code_analyzer_service.model.CodeAnalysisResponse;

public interface GeminiApiClient {
    CodeAnalysisResponse analyzeCode(CodeAnalysisRequest request);
}