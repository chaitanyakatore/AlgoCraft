package com.example.problemgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemRequest {
    private String title;
    private String description;
    private String inputFormat;
    private String outputFormat;
    private String constraints;
    private String testCases; 
    private DifficultyLevel difficulty;
    private String tags; 

   
}
