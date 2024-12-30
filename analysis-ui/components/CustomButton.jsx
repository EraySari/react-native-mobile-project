import { View, Text, TouchableOpacity } from "react-native";
import React from "react";

const CustomButton = ({ title, handlePress, containerStlyes, disabled }) => {
  return (
    <TouchableOpacity
      onPress={handlePress}
      activeOpacity={0.5}
      disabled={disabled}
      className={`bg-teal-600 rounded-xl min-h-[58px] justify-center items-center ${containerStlyes}`}
    >
      <Text className="text-gray-200 font-psemibold text-lg">{title}</Text>
    </TouchableOpacity>
  );
};

export default CustomButton;
