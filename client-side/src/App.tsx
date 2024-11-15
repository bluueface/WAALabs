import React from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import { PostProvider } from "./context/PostContext";

function App() {
  return (
    <div className="h-screen p-3 text-white bg-gray-950">
      <PostProvider>
        <Dashboard />
      </PostProvider>
    </div>
  );
}

export default App;
