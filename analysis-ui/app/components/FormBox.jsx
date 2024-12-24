import { View, Text, TextInput } from "react-native";
import React, { useState } from "react";

const FormBox = ({
  title,
  otherStyles,
  value,
  placeholder,
  handleChangeText,
}) => {
  const [showPassword, setShowPassword] = useState(null);
  return (
    <View className={`space-y-2 ${otherStyles}`}>
      <Text className="text-base font-pmedium">{title}</Text>
      <View className="border-2 border-teal-800 bg-gray-200 w-full h-12 px-4 rounded-2xl focus:border-s-emerald-400">
        <TextInput
          className="flex-1 font-psemibold text-base"
          value={value}
          placeholder={placeholder}
          placeholderTextColor="#7b7b8b"
          onChangeText={handleChangeText}
          secureTextEntry={title === "Password" && !showPassword}
        />
      </View>
    </View>
  );
};

export default FormBox;
