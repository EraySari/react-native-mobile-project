import { View, Text } from "react-native";
import React from "react";
import { Tabs } from "expo-router";
import { icons } from "../../constants";

const TabIcon = ({ icon, color, name }) => {
  return (
    <View>
      <Image source={icon} tintColor={color} />
      <Text>{name}</Text>
    </View>
  );
};

const TabsLayout = () => {
  return (
    <>
      <Tabs
        screenOptions={{
          tabBarActiveTintColor: "#FFA001",
          tabBarInactiveTintColor: "#CDCDE0",
          tabBarShowLabel: false,
          tabBarStyle: {
            backgroundColor: "#161622",
            borderTopWidth: 1,
            borderTopColor: "#232533",
            height: 70,
          },
        }}
      >
        <Tabs.Screen
          name="home" //nested childrenlara bakar bu isme götürür
          options={{
            title: "Home",
            headerShown: false,
            tadBarIcon: ({ color, focused }) => {
              <TabIcon icon={icons.home} color={color} name="Home" />;
            },
          }}
        />
        <Tabs.Screen
          name="create"
          options={{ title: "Create", headerShown: false }}
        />
        <Tabs.Screen
          name="profile"
          options={{ title: "Profile", headerShown: false }}
        />
      </Tabs>
    </>
  );
};

export default TabsLayout;
