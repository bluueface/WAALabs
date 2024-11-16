import React, { useEffect, useState } from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import { PostProvider, usePostContext } from "./context/PostContext";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import Posts from "./components/Posts";
import { PostInterface } from "./utils/types";
import { PostService } from "./services/postService";
import AddPost from "./components/AddPost";
import Main from "./components/Main";
import PostDetails from "./components/PostDetails";

function AppContent() {
  const { reload, setReload } = usePostContext();
  const [posts, setPosts] = useState<PostInterface[]>([]);

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
  }, [reload, setReload]);

  useEffect(() => {
    fetchPost();
  }, []);

  const routes = createBrowserRouter(
    createRoutesFromElements(
      <Route element={<Main />}>
        <Route index element={<Dashboard />} />
        <Route path="/posts" element={<Posts posts={posts} />} />
        <Route path="/posts/new-post" element={<AddPost />} />
        <Route path="posts/:postId" element={<PostDetails />} />
      </Route>
    )
  );

  return <RouterProvider router={routes} />;
}

function App() {
  return (
    <PostProvider>
      <AppContent />
    </PostProvider>
  );
}

export default App;
