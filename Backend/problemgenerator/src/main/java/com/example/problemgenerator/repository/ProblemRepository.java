package com.example.problemgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.problemgenerator.entity.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

}
