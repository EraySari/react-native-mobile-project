import { View, Text, ScrollView, Image } from "react-native";
import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import { images } from "../../constants";
import FormBox from "../components/FormBox";
import { useState } from "react";
const SignIn = () => {
  const [form, setForm] = useState({
    name: "",
    surname: "",
    tc: "",
    birth: "",
    gender: "",
    email: "",
    password: "",
  });
  return (
    <SafeAreaView className="h-full">
      <ScrollView>
        <View className="justify-center w-full h-full px-4 my-6">
          <Image source={images.rfCheck} className="w-[155px] h-[65px] mr-7" />
          <Text className="text-xl font-psemibold mt-7">Log in to RfCheck</Text>
          <FormBox
            title="Name"
            value={form.name}
            handleChangeText={(e) => setForm({ ...setForm, name: e })}
            otherStyles="mt-8"
            placeholder="Name"
          />
          <FormBox
            title="Surname"
            value={form.surname}
            handleChangeText={(e) => setForm({ ...setForm, surname: e })}
            otherStyles="mt-8"
            placeholder="Surname"
          />
          <FormBox
            title="ID number"
            value={form.tc}
            handleChangeText={(e) => setForm({ ...setForm, tc: e })}
            otherStyles="mt-8"
            placeholder="ID Number"
          />
          <FormBox
            title="Birth Date"
            value={form.birth}
            handleChangeText={(e) => setForm({ ...setForm, birth: e })}
            otherStyles="mt-8"
            placeholder="Birth Date"
          />
          <FormBox
            title="Gender"
            value={form.gender}
            handleChangeText={(e) => setForm({ ...setForm, gender: e })}
            otherStyles="mt-8"
            placeholder="Gender"
          />
          <FormBox
            title="Email"
            value={form.email}
            handleChangeText={(e) => setForm({ ...setForm, email: e })}
            otherStyles="mt-8"
            placeholder="Email"
          />
          <FormBox
            title="Password"
            value={form.password}
            handleChangeText={(e) => setForm({ ...setForm, password: e })}
            otherStyles="mt-8"
            placeholder="Password"
          />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default SignIn;
