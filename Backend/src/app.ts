import express from "express";
import cors from "cors";
import dotenv from "dotenv";
// import problemRoutes from "./routes/problemRoutes";
// import submissionRoutes from "./routes/submissionRoutes";

dotenv.config();

const app = express();
app.use(cors());
app.use(express.json());

// app.use("/api/problems", problemRoutes);
// app.use("/api/submissions", submissionRoutes);
export default app;
