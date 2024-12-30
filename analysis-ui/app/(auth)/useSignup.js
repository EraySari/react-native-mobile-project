import { useMutation } from "@tanstack/react-query";
import { userSignup } from "../../services/apiAuth";
import { Alert } from "react-native";
import { router } from "expo-router";

export default function useSignup() {
  const { mutate: signupMutate, isPending } = useMutation({
    mutationFn: (data) => userSignup(data),

    onSuccess: () => {},
  });

  return { signupMutate, isPending };
}
