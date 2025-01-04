import { StyleSheet, Text, View, ScrollView } from "react-native";
import React from "react";
import { Redirect, router } from "expo-router";
import { StatusBar } from "expo-status-bar";
import { SafeAreaView } from "react-native-safe-area-context";
import { images } from "../constants";
import { Image } from "react-native";
import CustomButton from "../components/CustomButton";

const App = () => {
  return (
    <SafeAreaView className=" h-full">
      <ScrollView contentContainerStyle={{ height: "100%" }}>
        <View className="w-full justify-center items-center min-h-[85vh] px-4">
          <Image
            source={images.rfCheck}
            className="w-[350px] h-[250px] mr-14"
            resizeMode="contain"
          />
          <Text className="font-plight text-sm">
            Check your tejkst results easily
          </Text>

          <CustomButton
            title="Continue with National ID Number"
            handlePress={() => router.push("/sign-in")}
            containerStlyes="w-full mt-14"
          />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;

{
  /* <Text className="text-3xl font-pblack">RefCheck</Text>
<StatusBar style="auto" />
<Link href="/home">Go to home</Link>{" "}
burdan home'a yolluyoruz. Sonra home kendi _layout düzenini kullaniyor */
}
