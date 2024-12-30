import AsyncStorage from "@react-native-async-storage/async-storage";
import { createContext, useContext } from "react";
import { Alert } from "react-native";

const AuthContext = createContext();

export default function AuthProvider({ children }) {
  async function userToLocal(user) {
    return await AsyncStorage.setItem("user", JSON.stringify(user));
  }

  async function getUser() {
    const first = await AsyncStorage.getItem("user");
    const parseData = JSON.parse(first);

    return parseData;
  }

  return (
    <AuthContext.Provider value={{ userToLocal, getUser }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}
