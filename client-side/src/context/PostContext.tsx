import { createContext, ReactNode, useContext, useState } from "react";

interface SelectedPostInterface {
  selectedPostId?: number;
  setSelectedPostId: (id?: number) => void;
  reload?: boolean;
  setReload: (value: boolean) => void;
}

export const PostContext = createContext<SelectedPostInterface | undefined>(
  undefined
);

export const PostProvider = ({ children }: { children: ReactNode }) => {
  const [selectedPostId, setSelectedPostId] = useState<number | undefined>();
  const [reload, setReload] = useState<boolean>(false);

  return (
    <PostContext.Provider
      value={{
        selectedPostId,
        setSelectedPostId,
        reload,
        setReload,
      }}
    >
      {children}
    </PostContext.Provider>
  );
};

export const usePostContext = () => {
  const context = useContext(PostContext);

  if (!context) {
    throw new Error("usePostContext must be used within a PostProvider");
  }

  return context;
};
