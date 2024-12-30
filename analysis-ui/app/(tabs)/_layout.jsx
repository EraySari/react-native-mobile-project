import { View, Text, Image } from "react-native";
import React, { useEffect, useState } from "react";
import { Tabs } from "expo-router";
import { icons } from "../../constants";
import { StatusBar } from "expo-status-bar";
import { useAuth } from "../../context/authContext";

const TabIcon = ({ icon, color, name }) => {
  return (
    <View>
      <Image source={icon} tintColor={color} className="w-6 h-6" />
      <Text>{name}</Text>
    </View>
  );
};

const TabsLayout = () => {
  const [loading, setLoading] = useState(true);
  const [user, setUser] = useState(null);
  const { getUser } = useAuth();
  useEffect(() => {
    // localden user aliniyor
    const fetchUser = async () => {
      try {
        setLoading(true);
        const jsonData = await getUser();
        setUser(jsonData);
      } catch (error) {
        console.error("error");
      } finally {
        setLoading(false);
      }
    };

    fetchUser();
  }, []);

  if (loading) {
    return (
      <View>
        <Text>yükleniyor</Text>
      </View>
    );
  }

  return (
    <>
      <Tabs
        screenOptions={{
          tabBarActiveTintColor: "#FFA001",
          tabBarInactiveTintColor: "#CDCDE0",
          tabBarShowLabel: true,
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
          name="results"
          options={{ title: "My Results", headerShown: false }}
        />

        {user.role === "ADMIN" ? (
          <Tabs.Screen
            name="allUsers"
            options={{ title: "All users", headerShown: false }}
          />
        ) : (
          <Tabs.Screen
            name="create"
            options={{ title: "Create", headerShown: false }}
          />
        )}

        <Tabs.Screen
          name="profile"
          options={{ title: "Profile", headerShown: false }}
        />
      </Tabs>

      <StatusBar backgroundColor="#161622" style="light" />
    </>
  );
};

export default TabsLayout;
