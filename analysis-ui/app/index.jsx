import { StyleSheet, Text, View } from "react-native";
import React from "react";
import { Link } from "expo-router";
import { StatusBar } from "expo-status-bar";

const App = () => {
  return (
    <View className="flex-1 justify-center items-center bg-white">
      <Text className="text-3xl font-pblack">RefCheck</Text>
      <StatusBar style="auto" />
      <Link href="/profile">Go to Profilen</Link>
    </View>
  );
};

export default App;
