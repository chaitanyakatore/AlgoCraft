import mongoose from "mongoose";

const connectDB = async () => {
  try {
    await mongoose.connect(process.env.MONGO_URI || "");
    console.log("mongoDB connected");
  } catch (err) {
    console.error("mongoDB connection failed", err);
    process.exit(1);
  }
};

export default connectDB;
