import { Router } from "express";
import {
  createSubmission,
  getAllSubmissions,
  getProblemSubmissions,
  getSubmissionById,
  getUserSubmissions,
} from "../controllers/submission.controller";

const router = Router();

router.post("/submission", createSubmission);
router.get("/submissions", getAllSubmissions);
router.get("/submission/:id", getSubmissionById);
router.get("/users/:id/submissions", getUserSubmissions);
router.get("/problems/:id/submissions", getProblemSubmissions);

export default router;
