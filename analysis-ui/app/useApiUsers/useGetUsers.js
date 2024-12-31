import { View, Text } from "react-native";
import React from "react";
import { useQuery } from "@tanstack/react-query";
import { getAllUsers } from "../../services/apiUser";

const useGetUsers = (user) => {
  const { data, isPending } = useQuery({
    queryFn: () => getAllUsers(user),
    queryKey: ["users"],

    enabled: !!user,
  });
  return { data, isPending };
};

export default useGetUsers;
