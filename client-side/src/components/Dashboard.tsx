import React, { useEffect, useState } from "react";
import Posts from "./Posts";
import PostDetails from "./PostDetails";
import { DATA } from "../data";

export interface PostInterface {
  id: number;
  title: string;
  author: string;
}

const Dashboard = () => {
  const [posts, setPosts] = useState<PostInterface[]>(DATA);
  const [selectedPost, setSelectedPost] = useState<PostInterface>();
  const [isDisabled, setIsDisabled] = useState<boolean>(true);
  const [title, setTitle] = useState<string>("");

  useEffect(() => {
    if (selectedPost) {
      setIsDisabled(false);
    }
  }, [selectedPost]);

  const handleChangeButtonClicked = () => {
    const newPosts = [...posts];
    const postTochane = newPosts.find((post) => post.id === selectedPost?.id);
    postTochane!.author = title;
    setPosts(newPosts);
  };

  const handleTitleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setTitle(event.target.value);
  };

  return (
    <div className="p-2">
      <Posts posts={posts} setSelectedPost={setSelectedPost} />
      <div className="flex gap-4 py-6">
        <input
          placeholder="Enter title"
          className="px-2 text-black"
          onChange={handleTitleChange}
        />
        <button
          className={`${
            isDisabled ? "bg-gray-400" : "bg-green-600"
          } p-2 rounded`}
          disabled={!selectedPost}
          onClick={handleChangeButtonClicked}
        >
          Change
        </button>
      </div>
      {selectedPost && <PostDetails post={selectedPost} />}
    </div>
  );
};

export default Dashboard;
