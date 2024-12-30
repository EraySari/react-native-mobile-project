import { View, Text, Alert, StyleSheet } from "react-native";
import React, { useEffect, useState } from "react";
import { useAuth } from "../../context/authContext";
import { SafeAreaView } from "react-native-safe-area-context";

const Home = () => {
  const { getUser } = useAuth();
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        setLoading(true);
        const jsonData = await getUser();
        setUserData(jsonData);
      } catch (error) {
        console.error("errro");
      } finally {
        setLoading(false);
      }
    };

    fetchUser();
  }, []);

  return (
    <SafeAreaView className="h-full">
      <View>
        <Text className="font-pbold">
          Welcome back {!loading ? userData?.name || "Email yok" : "Loading"}
        </Text>
        <Text>Denehkhimed</Text>
      </View>
    </SafeAreaView>
  );
};

export default Home;

//base64 olustur
// profile sekmesinde kullanici kendini güncelleyebilsin
// zaman yeterse rowa basinca userdetails sayfasina yönlendirmeye bak ordan delete yap
