function calculateAgeAndMonths(birthDateString) {
  const birthDate = new Date(birthDateString); // Doğum tarihi
  const today = new Date(); // Bugünün tarihi

  let years = today.getFullYear() - birthDate.getFullYear();
  let months = today.getMonth() - birthDate.getMonth();

  if (months < 0 || (months === 0 && today.getDate() < birthDate.getDate())) {
    years--;
    months += 12;
  }

  return `${years} yıl ${months} ay`;
}

export default calculateAgeAndMonths;
