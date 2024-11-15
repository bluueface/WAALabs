import React, { useEffect, useState } from "react";
import Posts from "./Posts";
import PostDetails from "./PostDetails";
import { PostService } from "../services/postService";
import { PostInterface } from "../utils/types";
import AddPost from "./AddPost";

const Dashboard = () => {
  const [posts, setPosts] = useState<PostInterface[]>([]);
  const [selectedPostId, setSelectedPostId] = useState<number | undefined>();
  const [title, setTitle] = useState<string>("");
  const [reload, setReload] = useState<boolean>(false);

  const fetchPost = () => {
    PostService.getAllPosts().then((res) => {
      setPosts(res);
    });
  };

  useEffect(() => {
    if (reload) {
      fetchPost();
      setReload(false);
    }
  }, [reload]);

  useEffect(() => {
    if (!selectedPostId) {
      fetchPost();
    }
  }, [selectedPostId]);

  const handleChangeButtonClicked = () => {
    const newPosts = [...posts];
    const postTochane = newPosts.find((post) => post.id === selectedPostId);
    postTochane!.title = title;
    setPosts(newPosts);
  };

  const handleTitleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setTitle(event.target.value);
  };

  return (
    <div className="p-2">
      <Posts posts={posts} setSelectedPostId={setSelectedPostId} />
      {posts.length > 0 && (
        <div className="flex gap-4 py-6">
          <input
            placeholder="Enter title"
            className="px-2 text-black"
            onChange={handleTitleChange}
          />
          <button
            className={`${
              selectedPostId ? "bg-gray-400" : "bg-green-600"
            } p-2 rounded`}
            disabled={!selectedPostId}
            onClick={handleChangeButtonClicked}
          >
            Change
          </button>
        </div>
      )}
      <div className="flex flex-row gap-4">
        <AddPost setReload={setReload} />
        {selectedPostId && (
          <PostDetails
            postId={selectedPostId}
            setSelectedPostId={setSelectedPostId}
          />
        )}
      </div>
    </div>
  );
};

export default Dashboard;
