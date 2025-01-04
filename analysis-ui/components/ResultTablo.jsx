import { View, Text, StyleSheet } from "react-native";
import React, { useState } from "react";
import CustomButton from "./CustomButton";

const ResultTablo = ({ results, userValues }) => {
  console.log("results", results);
  return (
    <View>
      {Object.keys(results).map((category) => (
        <View key={category} style={styles.categoryContainer}>
          <Text className="bg-gray-300 py-4 text-center font-pextrabold text-base">
            {category} ({userValues[category]}){" "}
          </Text>
          {results[category].map((item, index) => (
            <View
              key={index}
              style={styles.row}
              className={
                item.status === "⬇️"
                  ? "bg-red-400"
                  : item.status === "⬆️"
                  ? "bg-blue-500"
                  : "bg-green-600"
              }
            >
              <Text style={styles.cell}>{item.guideType}</Text>
              <Text style={styles.cell}>{item.calculateType}</Text>
              <Text style={styles.cell}>{item.status}</Text>
            </View>
          ))}
        </View>
      ))}
    </View>
  );
};

const styles = StyleSheet.create({
  row: {
    flexDirection: "row",
    borderBottomWidth: 1,
    borderBottomColor: "#ccc",
  },
  cell: {
    flex: 1,
    padding: 10,
  },
});
export default ResultTablo;
