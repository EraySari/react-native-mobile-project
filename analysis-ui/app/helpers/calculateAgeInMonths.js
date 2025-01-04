export default function calculateAgeInMonths(birthDate) {
  const today = new Date();
  const birth = new Date(birthDate);
  const yearsDifference = today.getFullYear() - birth.getFullYear();
  const monthsDifference = today.getMonth() - birth.getMonth();

  return yearsDifference * 12 + monthsDifference;
}
