import {
  View,
  Text,
  TouchableOpacity,
  Alert,
  StyleSheet,
  FlatList,
} from "react-native";
import React, { useState } from "react";
import ShowInfos from "./ShowInfos";
import { formatDate } from "../app/helpers/formatDate";

const ResultRow = ({ refData, guideData }) => {
  const [showInfo, setShowInfo] = useState(false);

  console.log("qqqqqqqqqqqqqqqqqqqqqqqqqqqq", guideData);

  const userValues = {
    igA: refData.igA,
    igG: refData.igG,
    igG1: refData.igG1,
    igG2: refData.igG2,
    igG3: refData.igG3,
    igG4: refData.igG4,
    igM: refData.igM,
  };

  // Karşılaştırma fonksiyonu
  function compareValues(value, minValue, maxValue) {
    if (value < minValue) return "Düşük";
    if (value > maxValue) return "Yüksek";
    return "Aralıkta";
  }

  // Tabloda gösterilecek veriyi hazırlama
  function prepareData(userValues, guideData) {
    const result = {};
    for (const category in userValues) {
      const categoryName = category.toUpperCase();
      result[category] = [];

      for (const guideType in guideData) {
        guideData[guideType].forEach((item) => {
          if (item.valueName.toUpperCase() === categoryName) {
            result[category].push({
              guideType,
              calculateType: item.calculateType,
              status: compareValues(
                userValues[category],
                item.minValue,
                item.maxValue
              ),
            });
          }
        });
      }
    }
    return result;
  }

  const results = prepareData(userValues, guideData);

  const Table = ({ results }) => {
    return (
      <View>
        {Object.keys(results).map((category) => (
          <View key={category} style={styles.categoryContainer}>
            <Text style={styles.categoryTitle}>
              {category} ({userValues[category]})
            </Text>
            {results[category].map((item, index) => (
              <View key={index} style={styles.row}>
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

  return (
    <>
      <TouchableOpacity onPress={() => setShowInfo(!showInfo)}>
        <View className="py-4 border border-gray-300 ">
          <Text className="text-center">{formatDate(refData.date)}</Text>
        </View>
      </TouchableOpacity>
      {showInfo && (
        <View style={styles.container}>
          <Table results={results} />
        </View>
      )}
    </>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    backgroundColor: "#f5f5f5",
  },
  title: {
    fontSize: 20,
    fontWeight: "bold",
    marginBottom: 20,
  },
  table: {
    borderWidth: 1,
    borderColor: "#ccc",
  },
  row: {
    flexDirection: "row",
    borderBottomWidth: 1,
    borderBottomColor: "#ccc",
  },
  header: {
    flex: 1,
    fontWeight: "bold",
    padding: 10,
    backgroundColor: "#ddd",
  },
  cell: {
    flex: 1,
    padding: 10,
  },
  categoryTitle: {},
});
export default ResultRow;
