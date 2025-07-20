import mongoose, { Document, Schema } from "mongoose";

export interface ITestCase {
  input: string;
  output: string;
  explanation: string;
}

export interface IProblem extends Document {
  title: string;
  description: string;
  constraints: string[];
  sampleTestCases: ITestCase[];
  tags: string[];
  difficulty: string;
}

const ProblemSchema = new Schema<IProblem>(
  {
    title: { type: String, required: true },
    description: { type: String, required: true },
    constraints: [{ type: String }],
    sampleTestCases: [
      {
        input: { type: String },
        output: { type: String },
        explanation: { type: String },
      },
    ],
    tags: [{ type: String }],
    difficulty: { type: String },
  },
  { timestamps: true }
);

export default mongoose.model<IProblem>("Problem", ProblemSchema);
