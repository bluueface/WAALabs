import { PostInterface } from "../utils/types";
import Post from "./Post";

interface Props {
  posts: PostInterface[];
}
const Posts: React.FunctionComponent<Props> = ({ posts }) => {
  return (
    <div className="grid place-items-center grid-cols-6 gap-4">
      {posts.map((post) => (
        <Post key={post.id} post={post} />
      ))}
    </div>
  );
};

export default Posts;
