import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  StyleSheet,
  ScrollView,
} from "react-native";
import DateTimePicker from "@react-native-community/datetimepicker";
import { SafeAreaView } from "react-native-safe-area-context";
import CustomButton from "../../components/CustomButton";
import useFindByMonth from "../useApiValues/useFindByMonth";
import { useAuth } from "../../context/authContext";
import calculateAgeInMonths from "../helpers/calculateAgeInMonths";
import groupedDatabyGuideType from "../helpers/dataByGuideType";
import prepareData from "../helpers/prepareData";
import SearchResultTable from "../../components/SearchResultTable";

const ImmuneForm = () => {
  const [formData, setFormData] = useState({
    igA: "",
    igG: "",
    igG1: "",
    igG2: "",
    igG3: "",
    igG4: "",
    igM: "",
    birthDate: "",
  });
  const [showDatePicker, setShowDatePicker] = useState(false);
  const [loading, setLoading] = useState(true);
  const [admin, setAdmin] = useState(null);
  const [byGuide, setByGuide] = useState({});
  const [showResults, setShowResults] = useState(false);

  const { getUser } = useAuth();
  const { findMonthMutate } = useFindByMonth();

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

  const handleInputChange = (name, value) => {
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = () => {
    alert("Form submitted!");
    setShowResults(!showResults);

    const months = calculateAgeInMonths(formData?.birthDate);
    findMonthMutate(
      { admin: admin, month: months },
      {
        onSuccess: (data) => {
          console.log("dönen degerr", data);
          const guide = groupedDatabyGuideType(data);
          setByGuide(guide);
        },
      }
    );
  };

  if (loading) {
    return (
      <View>
        <Text>Loading...</Text>
      </View>
    );
  }

  console.log("ääääääää", showResults);
  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-10">
        <Text className="font-pbold text-2xl mb-9 text-center">
          Search Value
        </Text>
        <View style={styles.container}>
          <View style={styles.row}>
            {["igA", "igG", "igG1"].map((field) => (
              <View key={field} style={styles.inputGroupRow}>
                <Text style={styles.label}>{field}:</Text>
                <TextInput
                  style={styles.input}
                  value={formData[field]}
                  placeholder="0.0"
                  onChangeText={(value) => handleInputChange(field, value)}
                  keyboardType="numeric"
                />
              </View>
            ))}
          </View>
          <View style={styles.row}>
            {["igG2", "igG3", "igG4"].map((field) => (
              <View key={field} style={styles.inputGroupRow}>
                <Text style={styles.label}>{field}:</Text>
                <TextInput
                  style={styles.input}
                  value={formData[field]}
                  placeholder="0.0"
                  onChangeText={(value) => handleInputChange(field, value)}
                  keyboardType="numeric"
                />
              </View>
            ))}
          </View>
          <View style={styles.row}>
            <View style={styles.inputGroupRow}>
              <Text style={styles.label}>igM:</Text>
              <TextInput
                style={styles.input}
                value={formData.igM}
                placeholder="0.0"
                onChangeText={(value) => handleInputChange("igM", value)}
                keyboardType="numeric"
              />
            </View>
            <View style={styles.inputGroupRow}>
              <Text style={styles.label}>Birth Date:</Text>
              <TextInput
                style={styles.input}
                value={formData.birthDate}
                placeholder="yyyy-mm-dd"
                onChangeText={(value) => handleInputChange("birthDate", value)}
                keyboardType="numeric"
              />
            </View>
          </View>

          <CustomButton handlePress={() => handleSubmit()} title="Search" />

          {showResults && (
            <SearchResultTable formData={formData} byGuide={byGuide} />
          )}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
    marginBottom: 15,
  },
  inputGroupRow: {
    flex: 1,
    marginHorizontal: 5,
  },
  label: {
    fontSize: 16,
    marginBottom: 5,
  },
  input: {
    borderWidth: 2,
    borderColor: "#ccc",
    padding: 10,
    borderRadius: 5,
  },
});
export default ImmuneForm;
