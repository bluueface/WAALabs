import { PostInterface } from "./Dashboard";
import Post from "./Post";

interface Props {
  posts: PostInterface[];
  setSelectedPost: (value: PostInterface) => void;
}
const Posts: React.FunctionComponent<Props> = ({ posts, setSelectedPost }) => {
  return (
    <div className="grid place-items-center grid-cols-3 gap-1">
      {posts.map((post) => (
        <Post key={post.id} post={post} setSelectedPost={setSelectedPost} />
      ))}
    </div>
  );
};

export default Posts;
