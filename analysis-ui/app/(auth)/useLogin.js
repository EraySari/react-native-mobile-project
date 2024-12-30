import { View, Text, Alert } from "react-native";
import React from "react";
import { useMutation } from "@tanstack/react-query";
import { userLogin } from "../../services/apiAuth";
import { router } from "expo-router";
import toast from "../../utils/toast";
import base64 from "react-native-base64";
import { useAuth } from "../../context/authContext";

const useLogin = () => {
  const { userToLocal } = useAuth();

  const { mutate: loginMutate, isPending } = useMutation({
    mutationFn: ({ tc, password }) => userLogin(tc, password),

    onSuccess: (data) => {
      const basicAuth = base64.encode(`${data.tc}:${data.password}`);

      userToLocal({ ...data, basicAuth });

      toast.success("Login Basarili");
      router.replace("/home");
    },

    onError: () => {},
  });
  return { loginMutate, isPending };
};

export default useLogin;
