import React from "react";
import { PostInterface } from "../utils/types";

interface Props {
  post: PostInterface;
  setSelectedPostId: (value?: number) => void;
}

const Post: React.FunctionComponent<Props> = ({ post, setSelectedPostId }) => {
  const renderLabel = (label: string, value?: string | number) => (
    <label>{`${label}:  ${value}`}</label>
  );
  return (
    <div
      className="flex flex-col p-6 bg-gray-950 border-2 border-gray-500  rounded cursor-pointer  "
      onClick={() => setSelectedPostId(post.id)}
    >
      {renderLabel("Id", post.id)}
      {renderLabel("Title", post.title)}
      {renderLabel("Author", post.userName)}
    </div>
  );
};

export default Post;
