import { useMutation } from "@tanstack/react-query";
import { getReferenceByName } from "../../services/apiReference";
import { Alert } from "react-native";

const useGetbyName = () => {
  const { mutate: searchMutate, isPending: isSearching } = useMutation({
    mutationFn: (data) => getReferenceByName(data),
    mutationKey: ["references"],

    onError: (err) => {
      Alert.alert(err.message);
    },
  });
  return { searchMutate, isSearching };
};

export default useGetbyName;
