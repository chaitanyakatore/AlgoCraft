import { Request, Response } from "express";
import Submission from "../models/Submission";

export const createSubmission = async (req: Request, res: Response) => {
  try {
    const submission = new Submission(req.body);
    await submission.save();
    res.status(201).json(submission);
  } catch (err) {
    res.status(500).json({ message: "Submission failed", error: err });
  }
};

// Get all submissions
export const getAllSubmissions = async (_: Request, res: Response) => {
  try {
    const submissions = await Submission.find();
    res.status(200).json(submissions);
  } catch (err) {
    res
      .status(500)
      .json({ message: "Failed to fetch submissions", error: err });
  }
};

// Get submission by ID
export const getSubmissionById = async (req: Request, res: Response) => {
  try {
    const submission = await Submission.findById(req.params.id);
    if (!submission)
      return res.status(404).json({ message: "Submission not found" });
    res.status(200).json(submission);
  } catch (err) {
    res.status(500).json({ message: "Error getting submission", error: err });
  }
};

// Get submissions by user
export const getUserSubmissions = async (req: Request, res: Response) => {
  try {
    const submissions = await Submission.find({ user: req.params.id });
    res.status(200).json(submissions);
  } catch (err) {
    res
      .status(500)
      .json({ message: "Failed to get user submissions", error: err });
  }
};

// Get submissions by problem
export const getProblemSubmissions = async (req: Request, res: Response) => {
  try {
    const submissions = await Submission.find({ problem: req.params.id });
    res.status(200).json(submissions);
  } catch (err) {
    res
      .status(500)
      .json({ message: "Failed to get problem submissions", error: err });
  }
};
