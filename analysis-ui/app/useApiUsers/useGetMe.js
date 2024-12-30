import { useMutation } from "@tanstack/react-query";
import { getMe } from "../../services/apiAuth";
import toast from "../../utils/toast";

const useGetMe = () => {
  const { mutate: getMeMutate, isPending } = useMutation({
    mutationFn: (user) => getMe(user),

    onSuccess: () => {
      toast.success("User data successfully fetched");
    },

    onError: () => {},
  });
  return { getMeMutate, isPending };
};

export default useGetMe;
