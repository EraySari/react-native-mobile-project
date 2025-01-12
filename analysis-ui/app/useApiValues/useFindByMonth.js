import { useMutation } from "@tanstack/react-query";
import { getMe } from "../../services/apiAuth";
import toast from "../../utils/toast";
import { findByMonth } from "../../services/apiValues";

const useFindByMonth = () => {
  const { mutate: findMonthMutate, isPending: isFetching } = useMutation({
    mutationFn: (user) => findByMonth(user),
    mutationKey: ["valuesByMonths"],
  });
  return { findMonthMutate, isFetching };
};

export default useFindByMonth;
