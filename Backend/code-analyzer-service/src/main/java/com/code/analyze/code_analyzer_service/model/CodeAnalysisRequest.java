package com.code.analyze.code_analyzer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeAnalysisRequest {
    private String code;
    private String language;
}
