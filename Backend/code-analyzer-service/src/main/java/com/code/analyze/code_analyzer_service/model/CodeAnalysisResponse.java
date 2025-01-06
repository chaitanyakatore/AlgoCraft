package com.code.analyze.code_analyzer_service.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeAnalysisResponse {
    private String timeComplexity;
    private String spaceComplexity;
    private List<String> suggestions;
}
