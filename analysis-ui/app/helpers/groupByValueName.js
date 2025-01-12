import { View, Text } from "react-native";
import React from "react";

function groupByValueName(data) {
  const result = {};
  for (const [key, items] of Object.entries(data)) {
    result[key] = {};
    items.forEach((item) => {
      const valueName = item.valueName;
      if (!result[key][valueName]) {
        result[key][valueName] = [];
      }
      // `valueName`e göre gruplama
      result[key][valueName].push({
        calculateType: item.calculateType,
        guideType: item.guideType,
        id: item.id,
        maxMonth: item.maxMonth,
        maxValue: item.maxValue,
        minMonth: item.minMonth,
        minValue: item.minValue,
      });
    });
  }

  return result;
}

export default groupByValueName;
