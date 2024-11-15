import { PostInterface } from "../utils/types";
import Post from "./Post";

interface Props {
  posts: PostInterface[];
  setSelectedPostId: (value?: number) => void;
}
const Posts: React.FunctionComponent<Props> = ({
  posts,
  setSelectedPostId,
}) => {
  return (
    <div className="grid place-items-center grid-cols-6 gap-4">
      {posts.map((post) => (
        <Post key={post.id} post={post} setSelectedPostId={setSelectedPostId} />
      ))}
    </div>
  );
};

export default Posts;
