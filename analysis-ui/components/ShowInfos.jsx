import { View, Text, TextInput, ScrollView } from "react-native";
import React, { useEffect, useState } from "react";
import Table from "./Table";
import useDeleteUser from "../app/useApiUsers/useDeleteUser";
import CustomButton from "./CustomButton";
import { StyleSheet } from "react-native";
import { useAuth } from "../context/authContext";
import useAddReference from "../app/useApiReference/useAddReference";

const ShowInfos = ({ user, authdata }) => {
  const { deleteMutate, isPending } = useDeleteUser();
  const [addTable, setAddTable] = useState(false);
  const [admin, setAdmin] = useState(null);
  const [loading, setLoading] = useState(true);
  const deleteUserData = { ...user, authdata: authdata };

  const { getUser } = useAuth();

  const { addRefMutate } = useAddReference();

  const handleDelete = () => {
    deleteMutate(deleteUserData);
  };

  const [formData, setFormData] = useState({
    igG: "",
    igA: "",
    igG1: "",
    igG2: "",
    igG3: "",
    igG4: "",
    igM: "",
  });

  useEffect(() => {
    // localden admin aliniyor
    const fetchUser = async () => {
      try {
        setLoading(true);
        const jsonData = await getUser();
        setAdmin(jsonData);
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

  function handleInputChange(ig, value) {
    setFormData({ ...formData, [ig]: value });
  }

  function handleSave() {
    const dataPacket = {
      ...formData,
      basicAuth: admin.basicAuth,
      id: user.id,
    };

    addRefMutate(dataPacket);
    //findMonthMutate(dataPacket);
  }

  return (
    <>
      <Table.Row>
        <Text>ID: {user.tc}</Text>
        <Text>Month: {user.month}</Text>
        <Text className="text-sm">Email: {user.email}</Text>
        <Text>Birth: {user.birthDate}</Text>

        <View>
          <CustomButton
            title="Delete"
            handlePress={() => handleDelete()}
            disabled={isPending}
            textStyles="text-sm"
            containerStlyes="bg-red-500"
          />
          <CustomButton
            title="Add Ref"
            disabled={isPending}
            handlePress={() => setAddTable(!addTable)}
            textStyles="text-sm"
          />
        </View>
      </Table.Row>

      {addTable && (
        <ScrollView contentContainerStyle={styles.container}>
          {/* igG */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igG:</Text>
            <TextInput
              style={styles.input}
              placeholder="igG"
              value={formData.igG}
              onChangeText={(value) => handleInputChange("igG", value)}
            />
          </View>

          {/* igGA */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igA:</Text>
            <TextInput
              style={styles.input}
              placeholder="igA"
              value={formData.igA}
              onChangeText={(value) => handleInputChange("igA", value)}
            />
          </View>

          {/* igG1 */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igG1:</Text>
            <TextInput
              style={styles.input}
              placeholder="igG1"
              value={formData.igG1}
              onChangeText={(value) => handleInputChange("igG1", value)}
            />
          </View>

          {/* igG2 */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igG2:</Text>
            <TextInput
              style={styles.input}
              placeholder="igG2"
              value={formData.igG2}
              onChangeText={(value) => handleInputChange("igG2", value)}
            />
          </View>

          {/* igG3 */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igG3:</Text>
            <TextInput
              style={styles.input}
              placeholder="igG3"
              value={formData.igG3}
              onChangeText={(value) => handleInputChange("igG3", value)}
            />
          </View>

          {/* igG4 */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igG4:</Text>
            <TextInput
              style={styles.input}
              placeholder="igG4"
              value={formData.igG4}
              onChangeText={(value) => handleInputChange("igG4", value)}
            />
          </View>

          {/* igM */}
          <View style={styles.inputGroup}>
            <Text style={styles.label}>igM:</Text>
            <TextInput
              style={styles.input}
              placeholder="igM"
              value={formData.igM}
              onChangeText={(value) => handleInputChange("igM", value)}
            />
          </View>

          {/* Save Button */}
          <CustomButton title="Add Ref" handlePress={handleSave} />
        </ScrollView>
      )}
    </>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  inputGroup: {
    marginBottom: 15,
  },
  label: {
    fontSize: 16,
    fontWeight: "bold",
    marginBottom: 5,
  },
  input: {
    borderWidth: 1,
    borderColor: "#ccc",
    borderRadius: 5,
    padding: 10,
    fontSize: 16,
  },
});

export default ShowInfos;

// ilk olarak guideType cek. Örnegin elimde 5 type var 5 farkli karsilastirma olacak
// find with month ile veriyi cek. Her birinin guide typeina bak ve kendi kategorisine ekleyip tabloda göster
// daha sonra herbirinin calculateTypelere bak,  sonra ona göre veriyi yukari mi asagi mi sorgula
