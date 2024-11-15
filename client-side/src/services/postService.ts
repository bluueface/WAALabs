import axiosInstance from "../utils/axiosConfig";
import { PostInterface } from "../utils/types";

export class PostService {
  static getAllPosts = async (): Promise<PostInterface[]> => {
    try {
      const response = await axiosInstance.get<PostInterface[]>("/posts");
      return response.data;
    } catch (error) {
      console.error("Get all posts error", error);
      throw error;
    }
  };

  static getPostById = async (id: number): Promise<PostInterface> => {
    try {
      const response = await axiosInstance.get<PostInterface>(`/posts/${id}`);
      return response.data;
    } catch (error) {
      console.error("Get post error", error);
      throw error;
    }
  };

  static deletePostById = async (id: number): Promise<void> => {
    try {
      await axiosInstance.delete(`/posts/${id}`);
    } catch (error) {
      console.error("Delete post error", error);
      throw error;
    }
  };

  static addPost = async (newPost: any): Promise<PostInterface> => {
    try {
      const response = await axiosInstance.post<PostInterface>(
        "/posts",
        newPost
      );
      console.log("Post added successfully:", response.data);
      return response.data;
    } catch (error) {
      console.error("Add post error", error);
      throw error;
    }
  };
}
