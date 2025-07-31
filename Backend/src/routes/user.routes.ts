import { Router } from "express";
import {
  createUser,
  getAllUsers,
  getUserById,
} from "../controllers/user.controller";

const router = Router();

router.post("/user", createUser);
router.get("/users", getAllUsers);
router.get("/user/:id", getUserById);

export default router;
