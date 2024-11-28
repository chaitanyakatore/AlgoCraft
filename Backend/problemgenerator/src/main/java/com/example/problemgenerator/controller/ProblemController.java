package com.example.problemgenerator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.problemgenerator.entity.Problem;
import com.example.problemgenerator.entity.ProblemRequest;
import com.example.problemgenerator.service.ProblemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/problems")
public class ProblemController {
    
    @Autowired
    private ProblemService problemService;

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody ProblemRequest problemRequest) {
        Problem problem = problemService.generateProblem(problemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(problem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable Long id) {
        return ResponseEntity.ok(problemService.getProblemById(id));
    }

    @GetMapping("/random")
    public ResponseEntity<Problem> getRandomProblem() {
        return ResponseEntity.ok(problemService.getRandomProblem());
    }
}
