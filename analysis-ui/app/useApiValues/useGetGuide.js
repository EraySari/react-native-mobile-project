import { useMutation } from "@tanstack/react-query";
import { getGuideType } from "../../services/apiValues";

const useGetGuide = () => {
  const { mutate: guideMutate, isPending: isFetcing } = useMutation({
    mutationFn: (user) => getGuideType(user),
    mutationKey: ["guideTypes"],
  });
  return { guideMutate, isFetcing };
};

export default useGetGuide;
