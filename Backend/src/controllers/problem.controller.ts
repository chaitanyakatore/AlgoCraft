import { Request, Response } from "express";
import Problem from "../models/Problem";

export const createProblem = async (req: Request, res: Response) => {
  try {
    const problem = new Problem(req.body);
    await problem.save();
    res.status(200).json(problem);
  } catch (err) {
    res.status(500).json({
      message: "Failed to create the problem",
      error: err instanceof Error ? err.message : err,
    });
  }
};

export const getAllProblems = async (req: Request, res: Response) => {
  try {
    const problems = await Problem.find();
    res.status(200).json(problems);
  } catch (err) {
    res.status(500).json({ message: "Failed to fetch problems" });
  }
};

export const getProblemById = async (req: Request, res: Response) => {
  try {
    const problem = await Problem.findById(req.params.id);
    if (!problem) return res.status(404).json({ message: "Problem not found" });
  } catch (err) {
    res.status(500).json({ message: "Error retrieving problem" });
  }
};

export const updateProblem = async (req: Request, res: Response) => {
  try {
    const problem = await Problem.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
    });
    res.status(200).json(problem);
  } catch (err) {
    res.status(500).json({ message: "Update failed" });
  }
};

export const deleteProblem = async (req: Request, res: Response) => {
  try {
    await Problem.findByIdAndDelete(req.params.id);
    res.status(204).send();
  } catch (err) {
    res.status(500).json({ message: "Delete failed" });
  }
};
