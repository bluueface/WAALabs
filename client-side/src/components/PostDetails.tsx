import { useEffect, useState } from "react";
import { PostInterface } from "../utils/types";
import { PostService } from "../services/postService";

interface Props {
  postId: number;
  setSelectedPostId: (value?: number) => void;
}
const PostDetails: React.FunctionComponent<Props> = ({
  postId,
  setSelectedPostId,
}) => {
  const [post, setPost] = useState<PostInterface>();

  useEffect(() => {
    PostService.getPostById(postId).then((res) => setPost(res));
  }, [postId]);

  const handleDeleteButtonClicked = () => {
    PostService.deletePostById(postId).then((res) => {
      setSelectedPostId(undefined);
      console.log(`Post with id ${postId} deleted successfully`);
    });
  };

  return (
    <div className="p-6 bg-gray-950 border-2 border-gray-500  rounded flex flex-col gap-4 flex-grow">
      {post && (
        <>
          <strong className="underline">{post.title}</strong>
          <span>{post.userName}</span>
          <p>{post.content}</p>
          <div className="p-3 flex gap-3">
            <button className="px-2 py-1 rounded bg-blue-700">Edit</button>
            <button
              className="px-2 py-1 rounded bg-red-600"
              onClick={handleDeleteButtonClicked}
            >
              delete
            </button>
          </div>
        </>
      )}
    </div>
  );
};

export default PostDetails;
