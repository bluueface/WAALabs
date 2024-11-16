import React from "react";
import { PostInterface } from "../utils/types";
import { useNavigate } from "react-router-dom";
import { usePostContext } from "../context/PostContext";

interface Props {
  post: PostInterface;
}

const Post: React.FunctionComponent<Props> = ({ post }) => {
  const navigate = useNavigate();
  const { setSelectedPostId } = usePostContext();

  const handleClick = () => {
    setSelectedPostId(post.id);
    navigate(`/posts/${post.id}`);
  };

  const renderLabel = (label: string, value?: string | number) => (
    <label>{`${label}:  ${value}`}</label>
  );
  return (
    <div
      className="flex flex-col p-6 bg-gray-950 border-2 border-gray-500  rounded cursor-pointer  "
      onClick={handleClick}
    >
      {renderLabel("Id", post.id)}
      {renderLabel("Title", post.title)}
      {renderLabel("Author", post.userName)}
    </div>
  );
};

export default Post;
