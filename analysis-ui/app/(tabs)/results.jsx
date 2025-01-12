import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  ScrollView,
  Alert,
  TouchableOpacity,
} from "react-native";

import { SafeAreaView } from "react-native-safe-area-context";
import CustomButton from "../../components/CustomButton";
import useFindByMonth from "../useApiValues/useFindByMonth";
import { useAuth } from "../../context/authContext";
import calculateAgeInMonths from "../helpers/calculateAgeInMonths";
import groupedDatabyGuideType from "../helpers/dataByGuideType";
import SearchResultTable from "../../components/SearchResultTable";
import Spinner from "../../components/Spinner";

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

  const [loading, setLoading] = useState(true);
  const [admin, setAdmin] = useState(null);
  const [byGuide, setByGuide] = useState({});
  const [showResults, setShowResults] = useState(false);
  const [isFocused, setIsFocused] = useState("");

  const [day, setDay] = useState(null);
  const [month, setMonth] = useState(null);
  const [year, setYear] = useState(null);

  const [inputBox, setInputBox] = useState(true);

  const { getUser } = useAuth();
  const { findMonthMutate, isFetching } = useFindByMonth();

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
    if (month > 12 || day > 31 || month > 2024) {
      Alert.alert("Date error");
      return;
    }

    setShowResults(!showResults);
    setInputBox(false);

    formData.birthDate = `${year}-${month}-${day}`;

    const months = calculateAgeInMonths(formData?.birthDate);
    findMonthMutate(
      { admin: admin, month: months },
      {
        onSuccess: (data) => {
          const guide = groupedDatabyGuideType(data);
          setByGuide(guide);
        },
      }
    );
  };

  if (loading) {
    return <Spinner />;
  }

  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-8">
        <Text className="font-pbold text-2xl mb-4 text-center">
          Search Value
        </Text>
        <View style={styles.container}>
          {inputBox && (
            <View>
              <View style={styles.dateRow}>
                <View style={styles.inputGroupRow}>
                  <Text style={styles.label}>GÜN</Text>
                  <TextInput
                    style={[
                      styles.input,
                      isFocused === "day" && styles.focused,
                    ]}
                    value={day}
                    placeholder="DD"
                    onChangeText={(value) => setDay(value)}
                    keyboardType="numeric"
                    onFocus={() => setIsFocused("day")}
                    onBlur={() => setIsFocused("")}
                  />
                </View>
                <View style={styles.inputGroupRow}>
                  <Text style={styles.label}>AY</Text>
                  <TextInput
                    style={[
                      styles.input,
                      isFocused === "month" && styles.focused,
                    ]}
                    value={month}
                    placeholder="MM"
                    onChangeText={(value) => setMonth(value)}
                    keyboardType="numeric"
                    onFocus={() => setIsFocused("month")}
                    onBlur={() => setIsFocused("")}
                  />
                </View>
                <View style={styles.inputGroupRow}>
                  <Text style={styles.label}>YIL</Text>
                  <TextInput
                    style={[
                      styles.input,
                      isFocused === "year" && styles.focused,
                    ]}
                    value={year}
                    placeholder="YYYY"
                    onChangeText={(value) => setYear(value)}
                    keyboardType="numeric"
                    onFocus={() => setIsFocused("year")}
                    onBlur={() => setIsFocused("")}
                  />
                </View>
              </View>

              <View style={styles.igValuesBox}>
                <View style={styles.row}>
                  {["IgA", "IgG", "IgM"].map((field) => (
                    <View key={field} style={styles.inputGroupRow}>
                      <Text style={styles.label}>{field}</Text>
                      <TextInput
                        style={[
                          styles.input,
                          isFocused === `${field}` && styles.focused,
                        ]}
                        value={formData[field]}
                        placeholder="0.0"
                        onChangeText={(value) =>
                          handleInputChange(field, value)
                        }
                        keyboardType="numeric"
                        onFocus={() => setIsFocused(`${field}`)}
                        onBlur={() => setIsFocused(false)}
                      />
                    </View>
                  ))}
                </View>
                <View style={styles.row}>
                  {["IgG1", "IgG2", "IgG3", "IgG4"].map((field) => (
                    <View key={field} style={styles.inputGroupRow}>
                      <Text style={styles.label}>{field}</Text>
                      <TextInput
                        style={[
                          styles.input,
                          isFocused === `${field}` && styles.focused,
                        ]}
                        value={formData[field]}
                        placeholder="0.0"
                        onChangeText={(value) =>
                          handleInputChange(field, value)
                        }
                        keyboardType="numeric"
                        onFocus={() => setIsFocused(`${field}`)}
                        onBlur={() => setIsFocused("")}
                      />
                    </View>
                  ))}
                </View>
              </View>

              <CustomButton
                handlePress={() => handleSubmit()}
                title="Analiz Et"
              />
            </View>
          )}

          {!inputBox && (
            <TouchableOpacity
              onPress={() => {
                setInputBox(!inputBox);
                setShowResults(!showResults);
              }}
            >
              <View style={styles.inputBoxButton}>
                <Text className="text-center text-sm font-psemibold">
                  Search for another values (click)
                </Text>
              </View>
            </TouchableOpacity>
          )}

          {showResults &&
            (!isFetching ? (
              <SearchResultTable formData={formData} byGuide={byGuide} />
            ) : (
              <Spinner />
            ))}
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    marginBottom: 40,
  },
  row: {
    flexDirection: "row",
    justifyContent: "space-between",
    marginBottom: 15,
  },
  igValuesBox: {
    justifyContent: "space-between",
    marginBottom: 35,
    paddingTop: 30,
    paddingBottom: 30,
    paddingLeft: 5,
    paddingRight: 5,
    borderWidth: 1,
    borderColor: "#D2D2F3",
    borderRadius: 5,
    backgroundColor: "#E5E6ED",
  },
  dateRow: {
    flexDirection: "row",
    justifyContent: "space-between",
    marginBottom: 35,
    paddingTop: 20,
    paddingBottom: 20,
    paddingLeft: 5,
    paddingRight: 5,
    borderWidth: 1,
    borderColor: "#D2D2F3",
    borderRadius: 5,
    backgroundColor: "#E5E6ED",
  },
  inputGroupRow: {
    flex: 1,
    marginHorizontal: 5,
  },
  label: {
    fontSize: 16,
    marginBottom: 5,
    fontWeight: "600",
  },
  input: {
    borderWidth: 1,
    borderColor: "#BDC2BF",
    padding: 10,
    borderRadius: 2,
    backgroundColor: "#F5F5F7",
  },
  focused: { borderColor: "#777978" },

  inputBoxButton: {
    backgroundColor: "#E5E6ED",
    padding: 18,
    borderWidth: 1,
    borderColor: "#D2D2F3",
  },
});
export default ImmuneForm;
