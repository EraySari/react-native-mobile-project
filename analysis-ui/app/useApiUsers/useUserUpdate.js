import { View, Text } from "react-native";
import React from "react";
import { useMutation } from "@tanstack/react-query";
import { updateUser } from "../../services/apiUser";
import toast from "../../utils/toast";

const useUserUpdate = () => {
  const { mutate: updateMutate, isPending } = useMutation({
    mutationFn: (user) => updateUser(user),
    mutationKey: ["users"],

    onSuccess: () => {
      console.log("update succes");
      toast.success("User successfully updated");
    },
  });
  return { updateMutate, isPending };
};

export default useUserUpdate;
