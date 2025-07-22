import mongoose, { Schema } from "mongoose";

export type SubmissionStatus =
  | "Pending"
  | "Accepted"
  | "Wrong Answer"
  | "Error";
export type Language = "js" | "ts" | "py" | "cpp" | "java";

export interface ISubmission extends Document {
  userId: mongoose.Types.ObjectId;
  problemId: mongoose.Types.ObjectId;
  language: Language;
  code: string;
  status: SubmissionStatus;
  output?: string;
}

const SubmissionSchema = new Schema<ISubmission>(
  {
    userId: { type: Schema.Types.ObjectId, ref: "User", required: true },
    problemId: { type: Schema.Types.ObjectId, ref: "Problem", required: true },
    language: {
      type: String,
      enum: ["js", "ts", "py", "cpp", "java"],
      required: true,
    },
    code: { type: String, required: true },
    status: {
      type: String,
      enum: ["Pending", "Accepted", "Wrong Answer", "Error"],
      default: "Pending",
    },
    output: { type: String },
  },
  { timestamps: true }
);

export default mongoose.model<ISubmission>("Submission", SubmissionSchema);
