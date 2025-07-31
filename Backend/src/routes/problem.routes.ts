import { Router } from "express";
import {
  createProblem,
  getAllProblems,
  getProblemById,
  updateProblem,
  deleteProblem,
} from "../controllers/problem.controller";

const router = Router();

router.post("/problem", createProblem);
router.get("/problems", getAllProblems);
router.get("/problem/:id", getProblemById);
router.put("/problem/:id", updateProblem);
router.delete("/problem/:id", deleteProblem);

export default router;
