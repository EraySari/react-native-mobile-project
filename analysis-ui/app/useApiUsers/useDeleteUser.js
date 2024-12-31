import { View, Text } from "react-native";
import React from "react";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { deleteUser } from "../../services/apiUser";
import toast from "../../utils/toast";

const useDeleteUser = () => {
  const clientQueries = useQueryClient();
  const { mutate: deleteMutate, isPending } = useMutation({
    mutationFn: (deleteUserData) => deleteUser(deleteUserData),
    mutationKey: ["users"],

    onSuccess: () => {
      toast.success("User succesfully deleted");

      clientQueries.invalidateQueries({
        queryKey: ["users"],
      });
    },
    onError: (err) => {
      toast.error(err.message);
    },
  });
  return { deleteMutate, isPending };
};

export default useDeleteUser;
