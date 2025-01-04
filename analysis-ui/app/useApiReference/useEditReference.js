import {
  QueryClient,
  useMutation,
  useQueryClient,
} from "@tanstack/react-query";
import { editReference } from "../../services/apiReference";
import { Alert } from "react-native";
import toast from "../../utils/toast";

const useEditReference = () => {
  const clientQueries = useQueryClient();
  const { mutate: editRefMutate, isPending: isEdit } = useMutation({
    mutationFn: (data) => editReference(data),
    onSuccess: () => {
      toast.success("Successfully");

      clientQueries.invalidateQueries({ queryKey: ["values"] });
    },
    onError: (err) => {
      Alert.alert(err.message);
    },
  });
  return { editRefMutate, isEdit };
};

export default useEditReference;
