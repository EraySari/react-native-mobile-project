import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  Alert,
  ScrollView,
} from "react-native";

import CustomButton from "../../components/CustomButton";
import CustomLabel from "../../components/CustomLabel";
import { SafeAreaView } from "react-native-safe-area-context";

import { useAuth } from "../../context/authContext";
import useUserUpdate from "../useApiUsers/useUserUpdate";

const Profile = () => {
  const [loading, setLoading] = useState(true);

  const { getUser } = useAuth();

  const { updateMutate, isPending } = useUserUpdate();

  const [user, setUser] = useState(null); // localden gelen veri buna kaydediliyor

  // const user1 = getMeMutate(); // l

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

  if (!loading) {
    console.log("profile ici: ", user);
  }
  const handleInputChange = (field, value) => {
    setUser({ ...user, [field]: value });
  };

  const handleSave = () => {
    // Güncellemeleri kontrol et
    console.log("guncellenmis user:", user);
    updateMutate(user);
  };

  if (loading) {
    return (
      <View>
        <Text>yükleniyor</Text>
      </View>
    );
  }

  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-10">
        <View className="min-h-[70vh] w-full justify-center">
          <Text className="font-pbold text-2xl mb-9 text-center">
            User Information
          </Text>

          <CustomLabel>Name</CustomLabel>
          <TextInput
            style={styles.input}
            value={user.name}
            onChangeText={(text) => handleInputChange("name", text)}
          />
          {/* Soyad */}
          <CustomLabel>Surname</CustomLabel>
          <TextInput
            style={styles.input}
            value={user.surname}
            onChangeText={(text) => handleInputChange("surname", text)}
          />

          <CustomLabel>Email</CustomLabel>
          <TextInput
            style={styles.input}
            value={user.email}
            onChangeText={(text) => handleInputChange("email", text)}
          />
          <CustomLabel>Gender</CustomLabel>
          <TextInput
            style={styles.input}
            value={user.gender}
            onChangeText={(text) => handleInputChange("gender", text)}
          />

          {/* Kaydet Butonu */}
          <View style={styles.buttonContainer}>
            <CustomButton
              title="Update"
              handlePress={handleSave}
              disabled={loading}
            />
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    borderColor: "#ccc",
    borderWidth: 1,
    borderRadius: 5,
    paddingHorizontal: 10,
    marginBottom: 15,
    backgroundColor: "#fff",
  },
  buttonContainer: {
    marginTop: 20,
  },
});

export default Profile;

//getMe kullanma guncellerken. Localden aldigin veri yukarda var güncellenmis hali onun kullan. Yeni bir useUpdate kullan onu kullan direkt yukardakini yolla
