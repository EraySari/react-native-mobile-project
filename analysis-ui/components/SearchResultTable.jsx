import { View, Text, ScrollView, StyleSheet } from "react-native";
import React from "react";
import prepareData from "../app/helpers/prepareData";

const SearchResultTable = ({ formData, byGuide }) => {
  const results = prepareData(formData, byGuide);
  const { birthDate, ...newResults } = results;

  const guideTypes = newResults["igA"].map((item) => item.guideType);

  return (
    <ScrollView horizontal>
      <View style={styles.tableContainer}>
        <Text style={styles.tableHeader}>Results Table</Text>
        <View style={styles.container}>
          <View style={styles.tableRow}>
            {Object.keys(newResults).map((category) => (
              <Text key={category} style={styles.tableCellHeader}>
                {category} ({formData[category] || "-"})
              </Text>
            ))}
          </View>

          {guideTypes.map((guideType, index) => (
            <View key={index} style={styles.tableRow}>
              {Object.keys(newResults).map((category) => {
                const metric = newResults[category][index];
                return (
                  <View
                    key={`${category}-${index}`}
                    style={styles.tableCell}
                    className={`${
                      formData[category] > metric?.maxValue
                        ? "bg-red-400"
                        : formData[category] < metric?.minValue
                        ? "bg-blue-200"
                        : "bg-green-200"
                    }`}
                  >
                    <View className="flex-col py-1">
                      <Text className="text-center">
                        {guideType}-{metric?.calculateType || "-"}
                      </Text>
                      <Text className="text-center">
                        ({metric?.minValue || "N/A"}-{metric?.maxValue || "N/A"}
                        )
                      </Text>
                      <Text className="text-center">
                        {category}({formData[category]})
                      </Text>
                    </View>
                  </View>
                );
              })}
            </View>
          ))}
        </View>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  tableContainer: {
    marginTop: 20,
    marginBottom: 80,
    borderWidth: 2,
    borderColor: "#b4b2b2",
    borderRadius: 10,
    padding: 10,
    minWidth: 750,
  },
  tableHeader: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 10,
    textAlign: "center",
  },
  tableRow: {
    flexDirection: "row",
    marginBottom: 5,
    borderBottomWidth: 0.4,
    borderBottomColor: "#ddd",
  },
  tableCell: {
    flex: 1,
    fontSize: 12,
    textAlign: "center",
    marginRight: 15,
    paddingHorizontal: 5,
    borderLeftWidth: 2,
    borderRightWidth: 2,
    minWidth: 170,
  },
  tableCellHeader: {
    flex: 1,
    fontSize: 14,
    fontWeight: "bold",
    textAlign: "center",
    paddingHorizontal: 5,
  },
  guideTypeHeader: {
    textAlign: "left",
  },
  header: {
    backgroundColor: "#f2f2f2",
    paddingVertical: 5,
  },
});

export default SearchResultTable;
