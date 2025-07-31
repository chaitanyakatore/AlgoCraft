// src/app.ts
import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import userRoutes from "./routes/user.routes";
import submissionRoutes from "./routes/submission.routes";
import problemRoutes from "./routes/problem.routes";

dotenv.config();

const app = express();
app.use(cors());
app.use(express.json());

app.use("/api", userRoutes); // ✅ Updated path
app.use("/api", submissionRoutes);
app.use("/api", problemRoutes);

export default app; // ✅ this is what you import in server.ts
