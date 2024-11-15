import { useEffect, useRef, useState } from "react";
import { PostInterface, UserInterface } from "../utils/types";
import { UserService } from "../services/userService";
import { PostService } from "../services/postService";

interface Props {
  setReload: (value: boolean) => void;
}

const AddPost: React.FunctionComponent<Props> = ({ setReload }) => {
  const titleRef = useRef<HTMLInputElement>(null);
  const contentRef = useRef<HTMLTextAreaElement>(null);
  const authorRef = useRef<HTMLSelectElement>(null);

  const [users, setUsers] = useState<UserInterface[]>([]);

  useEffect(() => {
    UserService.getAllUsers().then((res) => {
      setUsers(res);
    });
  }, []);

  const handleAddPostButtonClicked = () => {
    const newPost: PostInterface = {
      title: titleRef.current?.value || "",
      content: contentRef.current?.value || "",
      user: users.find((user) => user.id === Number(authorRef.current?.value)),
    };

    PostService.addPost(newPost).then((res) => {
      if (res) {
        setReload(true);
        if (titleRef.current) titleRef.current.value = "";
        if (contentRef.current) contentRef.current.value = "";
        if (authorRef.current) authorRef.current.value = "";
      }
    });
  };

  return (
    <div className="p-6 bg-gray-950 border-2 border-gray-500 rounded flex flex-col gap-4">
      <input placeholder="title" className="px-2 text-black" ref={titleRef} />
      <select className="px-2 text-black" ref={authorRef}>
        <option value="">--select Author--</option>
        {users.map((user: any) => (
          <option key={user.id} value={user.id}>
            {user?.name}
          </option>
        ))}
      </select>
      <textarea
        className="px-2 text-black"
        placeholder="content"
        ref={contentRef}
      />
      <button
        className="bg-green-600 p-2 rounded"
        onClick={handleAddPostButtonClicked}
      >
        Add new post
      </button>
    </div>
  );
};

export default AddPost;
