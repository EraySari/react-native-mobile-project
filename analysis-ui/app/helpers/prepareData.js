import { Text } from "react-native";

// Tabloda gösterilecek veriyi hazırlama
export default function prepareData(userValues, guideData) {
  const result = {};
  //console.log("iciicicicicic", userValues, guideData); // user aramada göstermeme hatasi burada guideData[]küme

  // Karşılaştırma fonksiyonu
  function compareValues(value, minValue, maxValue) {
    if (value < minValue) return "⬇️";
    if (value > maxValue) return "⬆️";
    return "✔️";
  }

  for (const category in userValues) {
    const categoryName = category.toUpperCase();
    result[category] = [];

    for (const guideType in guideData) {
      guideData[guideType].forEach((item) => {
        if (item.valueName.toUpperCase() === categoryName) {
          result[category].push({
            guideType,
            calculateType: item.calculateType,
            minValue: item.minValue,
            maxValue: item.maxValue,
            maxMonth: item.maxMonth,
            status: compareValues(
              userValues[category],
              item.minValue,
              item.maxValue
            ),
          });
        }
      });
    }
  }

  return result;
}