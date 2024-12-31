import { useMutation } from "@tanstack/react-query";
import { addReference } from "../../services/apiReference";
import { Alert } from "react-native";
import toast from "../../utils/toast";

const useAddReference = () => {
  const { mutate: addRefMutate, isPending: isAdded } = useMutation({
    mutationFn: (data) => addReference(data),
    onSuccess: () => {
      toast.success("Successfully");
    },
    onError: (err) => {
      Alert.alert(err.message);
    },
  });
  return { addRefMutate, isAdded };
};

export default useAddReference;
