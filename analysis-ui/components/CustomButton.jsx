import { View, Text, TouchableOpacity } from "react-native";
import React from "react";

const CustomButton = ({
  title,
  handlePress,
  containerStlyes,
  textStyles,
  disabled,
}) => {
  return (
    <TouchableOpacity
      onPress={handlePress}
      activeOpacity={0.5}
      disabled={disabled}
      className={`bg-teal-600 rounded-xl min-h-[55px] justify-center items-center mb-2 ${containerStlyes}`}
    >
      <Text className={`text-gray-200 font-psemibold text-lg ${textStyles}`}>
        {title}
      </Text>
    </TouchableOpacity>
  );
};

export default CustomButton;
