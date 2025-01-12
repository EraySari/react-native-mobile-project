import { View, Text, StyleSheet, ScrollView, TextInput } from "react-native";
import React, { useState } from "react";
import useAddReference from "../app/useApiReference/useAddReference";
import CustomButton from "./CustomButton";
import useEditReference from "../app/useApiReference/useEditReference";

const AddRefForm = ({
  user,
  admin,
  editValue = {},
  setShowEditInput,
  refData,
}) => {
  const { addRefMutate } = useAddReference();
  const { editRefMutate } = useEditReference();

  const updateDate = new Date();

  const [formData, setFormData] = useState({
    igG: editValue ? editValue.igG : "",
    igA: editValue ? editValue.igA : "",
    igG1: editValue ? editValue.igG1 : "",
    igG2: editValue ? editValue.igG2 : "",
    igG3: editValue ? editValue.igG3 : "",
    igG4: editValue ? editValue.igG4 : "",
    igM: editValue ? editValue.igM : "",
  });

  function handleInputChange(ig, value) {
    setFormData({ ...formData, [ig]: value });
  }

  function handleSave() {
    {
      editValue
        ? editRefMutate({
            ...formData,
            basicAuth: admin.basicAuth,
            refId: refData,
            userID: user,
            date: updateDate,
          })
        : addRefMutate({
            ...formData,
            basicAuth: admin.basicAuth,
            id: user.id,
          });
    }
    setShowEditInput(false);
  }

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <View style={styles.inputGroup}>
        <Text style={styles.label}>igG(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igG"
          value={String(formData.igG)}
          onChangeText={(value) => handleInputChange("igG", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igA(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igA"
          value={String(formData.igA)}
          onChangeText={(value) => handleInputChange("igA", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igG1(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igG1"
          value={String(formData.igG1)}
          onChangeText={(value) => handleInputChange("igG1", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igG2(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igG2"
          value={String(formData.igG2)}
          onChangeText={(value) => handleInputChange("igG2", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igG3(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igG3"
          value={String(formData.igG3)}
          onChangeText={(value) => handleInputChange("igG3", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igG4(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igG4"
          value={String(formData.igG4)}
          onChangeText={(value) => handleInputChange("igG4", value)}
        />
      </View>

      <View style={styles.inputGroup}>
        <Text style={styles.label}>igM(mg/dL):</Text>
        <TextInput
          style={styles.input}
          placeholder="igM"
          value={String(formData.igM)}
          onChangeText={(value) => handleInputChange("igM", value)}
        />
      </View>

      <CustomButton
        title={editValue ? "Edit Ref" : "Add Ref"}
        handlePress={handleSave}
      />
    </ScrollView>
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

export default AddRefForm;
