import axiosInstance from "../utils/axiosConfig";
import { UserInterface } from "../utils/types";

export class UserService {
  static getAllUsers = async (): Promise<UserInterface[]> => {
    try {
      const response = await axiosInstance.get<UserInterface[]>("/users");
      return response.data;
    } catch (error) {
      console.error("Get all users error", error);
      throw error;
    }
  };
}
