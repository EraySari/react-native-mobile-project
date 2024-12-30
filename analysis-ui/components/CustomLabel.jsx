import { View, Text } from "react-native";
import React from "react";

const CustomLabel = ({ children }) => {
  return <Text className="text-base font-pbold mb-1">{children}</Text>;
};

export default CustomLabel;
