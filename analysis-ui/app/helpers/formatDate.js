import { View, Text } from "react-native";
import React from "react";

export function formatDate(myDate) {
  const date = new Date(myDate);

  const formattedDate = date.toLocaleString("en-US", {
    year: "numeric",
    month: "long",
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
  });
  return formattedDate;
}
