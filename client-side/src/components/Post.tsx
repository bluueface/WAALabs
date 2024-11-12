import React from "react";
import { PostInterface } from "./Dashboard";

interface Props {
  post: PostInterface;
  setSelectedPost: (value: PostInterface) => void;
}

const Post: React.FunctionComponent<Props> = ({ post, setSelectedPost }) => {
  const renderLabel = (label: string, value: string | number) => (
    <label>{`${label}:  ${value}`}</label>
  );
  return (
    <div
      className="flex flex-col p-6 bg-gray-950 border-2 border-gray-500  rounded cursor-pointer  "
      onClick={() => setSelectedPost(post)}
    >
      {renderLabel("Id", post.id)}
      {renderLabel("Title", post.title)}
      {renderLabel("Author", post.author)}
    </div>
  );
};

export default Post;
