import { View, Text, ScrollView, Image, Alert } from "react-native";
import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import { images } from "../../constants";
import { useState } from "react";
import FormBox from "../../components/FormBox";
import CustomButton from "../../components/CustomButton";
import { Link, router } from "expo-router";
import useLogin from "./useLogin";
const SignIn = () => {
  const [tc, setTc] = useState("");
  const [password, setPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  const { loginMutate } = useLogin();

  const handleLogin = async function () {
    loginMutate({ tc, password });
  };
  return (
    <SafeAreaView className="h-full">
      <ScrollView>
        <View className="justify-center w-full min-h-[85vh] px-4 py-16">
          <Image source={images.rfCheck} className="w-[155px] h-[65px] mr-7" />
          <Text className="text-xl font-psemibold mt-7">
            Logs in to RfCheck
          </Text>
          <FormBox
            title="ID Number"
            value={tc}
            handleChangeText={(e) => setTc(e)}
            otherStyles="mt-8"
            placeholder="ID"
          />
          <FormBox
            title="Password"
            value={password}
            handleChangeText={(e) => setPassword(e)}
            otherStyles="mt-8"
            placeholder="Password"
          />
          <CustomButton
            title="Log In"
            containerStlyes="bg-teal-700 mt-10 mb-4"
            handlePress={handleLogin}
          />
          <View className="flex-row justify-center gap-2">
            <Text className="">Don`t have an account?</Text>
            <Link href="/sign-up" className="font-psemibold text-blue-700 ">
              Sign up
            </Link>
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default SignIn;

//router.push kullandim bi bak ona
