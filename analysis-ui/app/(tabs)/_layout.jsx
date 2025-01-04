import { View, Text, Image } from "react-native";
import React, { useEffect, useState } from "react";
import { Tabs } from "expo-router";
import { icons } from "../../constants";
import { StatusBar } from "expo-status-bar";
import { useAuth } from "../../context/authContext";
import Icon from "react-native-vector-icons/Ionicons";

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
          tabBarActiveTintColor: "#01a171",
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
            tabBarIcon: ({ color, focused }) => {
              return <Icon name="home" size={24} color={color} />;
            },
          }}
        />

        {user?.role === "ADMIN" ? (
          <Tabs.Screen
            name="create"
            options={{
              title: "User Results",
              headerShown: false,
              tabBarIcon: ({ color, focused }) => {
                return (
                  <Icon
                    name={focused ? "stats-chart" : "stats-chart-outline"}
                    size={24}
                    color={color}
                  />
                );
              },
            }}
          />
        ) : user?.role ? (
          <Tabs.Screen
            name="results"
            options={{
              title: "My Results",
              headerShown: false,
              tabBarIcon: ({ color, focused }) => {
                return (
                  <Icon
                    name={focused ? "stats-chart" : "stats-chart-outline"}
                    size={24}
                    color={color}
                  />
                );
              },
            }}
          />
        ) : null}

        {user?.role === "ADMIN" ? (
          <Tabs.Screen
            name="allusers"
            options={{
              title: "All users",
              headerShown: false,
              tabBarIcon: ({ color, focused }) => {
                return (
                  <Icon
                    name={focused ? "people" : "people-outline"}
                    size={24}
                    color={color}
                  />
                );
              },
            }}
          />
        ) : null}

        {user?.role === "ADMIN" ? (
          <Tabs.Screen
            name="results"
            options={{
              title: "Search",
              headerShown: false,
              tabBarIcon: ({ color, focused }) => {
                return (
                  <Icon
                    name={focused ? "search" : "search-outline"}
                    size={24}
                    color={color}
                  />
                );
              },
            }}
          />
        ) : null}
        <Tabs.Screen
          name="profile"
          options={{
            title: "Profile",
            headerShown: false,
            tabBarIcon: ({ color, focused }) => {
              return (
                <Icon
                  name={focused ? "person" : "person-outline"}
                  size={24}
                  color={color}
                />
              );
            },
          }}
        />
      </Tabs>

      <StatusBar backgroundColor="#161622" style="light" />
    </>
  );
};

export default TabsLayout;
