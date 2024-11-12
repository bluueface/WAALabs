import { PostInterface } from "./Dashboard";

interface Props {
  post: PostInterface;
}
const PostDetails: React.FunctionComponent<Props> = ({ post }) => {
  return (
    <div className="p-6 bg-gray-950 border-2 border-gray-500  rounded flex flex-col gap-4">
      <strong className="underline">{post.title}</strong>
      <span>{post.author}</span>
      <p>This the content in the post ...</p>
      <div className="p-3 flex gap-3">
        <button className="px-2 py-1 rounded bg-blue-700">Edit</button>
        <button className="px-2 py-1 rounded bg-red-600">delete</button>
      </div>
    </div>
  );
};

export default PostDetails;
