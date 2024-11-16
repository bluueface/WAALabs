import React from "react";
import { useNavigate } from "react-router-dom";

const Dashboard = () => {
  const navigate = useNavigate();

  const handlePostsBtnClicked = () => {
    navigate("/posts");
  };

  const handleAddPostBtnClicked = () => {
    navigate("/posts/new-post");
  };

  return (
    <div className="flex flex-col items-center justify-center flex-grow gap-4 p-4">
      <button
        className="bg-blue-600 p-2 rounded w-44"
        onClick={handlePostsBtnClicked}
      >
        Posts
      </button>
      <button
        className="bg-green-600 p-2 rounded w-44"
        onClick={handleAddPostBtnClicked}
      >
        Add Post
      </button>
    </div>
  );
};

export default Dashboard;
