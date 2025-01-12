import { View, Text, ScrollView, Image, Alert } from "react-native";
import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import { useState } from "react";
import FormBox from "../../components/FormBox";
import CustomButton from "../../components/CustomButton";
import useSignup from "./useSignup";
const SignUp = () => {
  const [form, setForm] = useState({
    name: "",
    surname: "",
    tc: "",
    birth: "",
    gender: "",
    email: "",
    password: "",
  });

  const { signupMutate, isPending } = useSignup();
  function handleSubmit() {
    signupMutate(form);
  }
  return (
    <SafeAreaView className="h-full">
      <ScrollView>
        <View className="justify-center w-full h-full px-4 py-16">
          <Image
            source={require("../../assets/images/rfcheck.png")}
            className="w-[155px] h-[65px] mr-7"
          />
          <Text className="text-xl font-psemibold mt-7">Log in to RfCheck</Text>
          <FormBox
            title="Name"
            value={form.name}
            handleChangeText={(e) => setForm({ ...form, name: e })}
            otherStyles="mt-8"
            placeholder="Name"
          />
          <FormBox
            title="Surname"
            value={form.surname}
            handleChangeText={(e) => setForm({ ...form, surname: e })}
            otherStyles="mt-8"
            placeholder="Surname"
          />
          <FormBox
            title="ID number"
            value={form.tc}
            handleChangeText={(e) => setForm({ ...form, tc: e })}
            otherStyles="mt-8"
            placeholder="ID Number"
          />
          <FormBox
            title="Birth Date"
            value={form.birth}
            handleChangeText={(e) => setForm({ ...form, birth: e })}
            otherStyles="mt-8"
            placeholder="Birth Date"
          />
          <FormBox
            title="Gender"
            value={form.gender}
            handleChangeText={(e) => setForm({ ...form, gender: e })}
            otherStyles="mt-8"
            placeholder="Gender"
          />
          <FormBox
            title="Email"
            value={form.email}
            handleChangeText={(e) => setForm({ ...form, email: e })}
            otherStyles="mt-8"
            placeholder="Email"
          />
          <FormBox
            title="Password"
            value={form.password}
            handleChangeText={(e) => setForm({ ...form, password: e })}
            otherStyles="mt-8"
            placeholder="Password"
          />
          <CustomButton
            title="Sign Up"
            containerStlyes="bg-teal-700 mt-10 "
            handlePress={() => handleSubmit()}
          />
          <Text>Do you have an account?</Text>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default SignUp;
