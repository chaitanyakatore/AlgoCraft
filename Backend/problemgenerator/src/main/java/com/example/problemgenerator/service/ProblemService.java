package com.example.problemgenerator.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.problemgenerator.entity.Problem;
import com.example.problemgenerator.entity.ProblemRequest;
import com.example.problemgenerator.repository.ProblemRepository;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public Problem generateProblem(ProblemRequest problemRequest) {
        // Process input description and generate problem details
        Problem problem = new Problem();
        problem.setTitle(problemRequest.getTitle());
        problem.setDescription(problemRequest.getDescription());
        problem.setInputFormat(problemRequest.getInputFormat());
        problem.setOutputFormat(problemRequest.getOutputFormat());
        problem.setConstraints(problemRequest.getConstraints());
        problem.setTestCases(problemRequest.getTestCases());
        problem.setDifficulty(problemRequest.getDifficulty());
        problem.setTags(problemRequest.getTags());

        return problemRepository.save(problem);
    }

    public Problem getProblemById(Long id) {
    return problemRepository.findById(id).orElse(null);
}


    public Problem getRandomProblem() {
        List<Problem> problems = problemRepository.findAll();
        return problems.get(new Random().nextInt(problems.size()));
    }
}
