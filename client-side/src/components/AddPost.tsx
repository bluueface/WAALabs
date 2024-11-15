import { useEffect, useState } from "react";
import { PostInterface, UserInterface } from "../utils/types";
import { UserService } from "../services/userService";
import { PostService } from "../services/postService";

interface Props {
  setReload: (value: boolean) => void;
}

const AddPost: React.FunctionComponent<Props> = ({ setReload }) => {
  const [post, setPost] = useState<PostInterface>();
  const [users, setUsers] = useState<any[]>([]);

  useEffect(() => {
    UserService.getAllUsers().then((res: UserInterface[]) => {
      setUsers(res);
    });
  }, []);

  const handleAddPostButtonClicked = () => {
    PostService.addPost(post).then((res) => {
      if (res) {
        setReload(true);
        setPost(undefined);
      }
    });
  };

  const handleTitleOnChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setPost({
      ...post,
      title: event.target.value,
    });
  };
  const handleAuthorOnChange = (
    event: React.ChangeEvent<HTMLSelectElement>
  ) => {
    setPost({
      ...post,
      user: users.find((user) => user.id == event.target.value),
    });
  };
  const handleContentOnChange = (
    event: React.ChangeEvent<HTMLTextAreaElement>
  ) => {
    setPost({
      ...post,
      content: event.target.value,
    });
  };

  return (
    <div className="p-6 bg-gray-950 border-2 border-gray-500  rounded flex flex-col gap-4">
      <input
        placeholder="title"
        className="px-2 text-black"
        value={post?.title ?? ""}
        onChange={handleTitleOnChange}
      />
      <select
        className="px-2 text-black"
        value={post?.user?.id ?? "--select Author--"}
        onChange={handleAuthorOnChange}
      >
        <option>--select Author--</option>
        {users?.map((user) => (
          <option key={user.id} value={user.id}>
            {user?.name}
          </option>
        ))}
      </select>
      <textarea
        className="px-2 text-black"
        placeholder="content"
        value={post?.content ?? ""}
        onChange={handleContentOnChange}
      />
      <button
        className={`${!post ? "bg-gray-400" : "bg-green-600"} p-2 rounded`}
        disabled={!post}
        onClick={handleAddPostButtonClicked}
      >
        Add new post
      </button>
    </div>
  );
};

export default AddPost;
