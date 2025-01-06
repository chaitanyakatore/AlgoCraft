package com.code.analyze.code_analyzer_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.code.analyze.code_analyzer_service.model.CodeAnalysisRequest;
import com.code.analyze.code_analyzer_service.model.CodeAnalysisResponse;

@Service
public class GeminiApiClientImpl implements GeminiApiClient {

    @Value("${gemini.api.url}")
    private String apiUrl;

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeminiApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CodeAnalysisResponse analyzeCode(CodeAnalysisRequest request) {
        // Create headers and add API key to headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);

        // Prepare request entity with headers and body
        HttpEntity<CodeAnalysisRequest> entity = new HttpEntity<>(request, headers);

        // Make the request to the Gemini API
        ResponseEntity<CodeAnalysisResponse> responseEntity = restTemplate.exchange(
                apiUrl, HttpMethod.POST, entity, CodeAnalysisResponse.class);

        // Return the analysis result from Gemini API
        return responseEntity.getBody();
    }
}
