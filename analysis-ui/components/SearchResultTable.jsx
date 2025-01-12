import { View, Text, ScrollView, StyleSheet } from "react-native";
import React from "react";
import prepareData from "../app/helpers/prepareData";
import groupByValueName from "../app/helpers/groupByValueName";
import calculateAgeMonth from "../app/helpers/calculateAgeMonth";

const SearchResultTable = ({ formData, byGuide }) => {
  const results = prepareData(formData, byGuide);
  const { birthDate, ...newResults } = results;

  const groupedData = groupByValueName(byGuide);

  const tableHeaders = ["GEOMETRIC", "MINMAX", "MEAN", "CI95"];

  const organizedResults = {};
  Object.entries(newResults).forEach(([key, dataList]) => {
    dataList.forEach((data) => {
      const guide = data.guideType;

      if (!organizedResults[guide]) {
        organizedResults[guide] = {};
      }
      if (!organizedResults[guide][data.calculateType]) {
        organizedResults[guide][data.calculateType] = [];
      }
      organizedResults[guide][data.calculateType].push({ ...data, type: key });
    });
  });

  return (
    <ScrollView style={styles.container}>
      {Object.entries(organizedResults).map(
        ([guideType, value], guideIndex) => (
          <View key={guideIndex} style={styles.guideContainer}>
            <View style={styles.table}>
              <Text style={styles.headerText}>
                {guideType} | Aralik {value.CI95[0].minMonth}-{" "}
                {value.CI95[0].maxMonth}
                {` (${calculateAgeMonth(formData.birthDate)})`}
              </Text>
              <View style={styles.row}>
                <Text style={[styles.cell, styles.bold]}></Text>
                {tableHeaders.map((header, index) => (
                  <Text key={index} style={[styles.cell, styles.bold]}>
                    {header}
                  </Text>
                ))}
              </View>

              {["IgA", "IgG", "IgM", "IgG1", "IgG2", "IgG3", "IgG4"].map(
                (igType, rowIndex) => {
                  const igData = groupedData?.[guideType]?.[igType] || [];

                  return (
                    <View key={rowIndex} style={styles.row}>
                      <Text style={styles.cell}>
                        {igType} ({formData?.[igType] || "-"})
                      </Text>
                      {tableHeaders.map((calcType) => {
                        const igValue = igData.find(
                          (item) => item.calculateType === calcType
                        );
                        return (
                          <Text
                            style={styles.cell}
                            className={
                              igValue
                                ? formData?.[igType] < igValue.minValue
                                  ? "bg-blue-200"
                                  : formData?.[igType] > igValue.maxValue
                                  ? "bg-red-200"
                                  : "bg-green-300"
                                : "bg-slate-50"
                            }
                          >
                            <Text className="text-xs font-pextrabold">
                              {igValue &&
                                formData?.[igType] < igValue.minValue &&
                                "⬇ "}
                            </Text>
                            {igValue
                              ? `${igValue.minValue}${
                                  formData?.[igType] < igValue.minValue
                                    ? " – "
                                    : formData?.[igType] > igValue.maxValue
                                    ? " – "
                                    : "⇔"
                                }${igValue.maxValue}`
                              : "-"}

                            <Text className="text-xs font-pextrabold">
                              {igValue &&
                                formData?.[igType] > igValue.maxValue &&
                                " ⬆"}
                            </Text>
                          </Text>
                        );
                      })}
                    </View>
                  );
                }
              )}
            </View>
          </View>
        )
      )}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  headerText: {
    fontSize: 12,
    fontWeight: "bold",
    textAlign: "center",
    marginBottom: 10,
  },
  guideContainer: {
    marginTop: 15,
  },
  guideTitle: {
    fontSize: 16,
    fontWeight: "bold",
    textAlign: "center",
    marginVertical: 8,
  },
  table: {
    borderWidth: 1,
    borderColor: "#8f8d8d",
    marginBottom: 5,
    padding: 5,
    backgroundColor: "#dbdef3c7",
  },
  row: {
    flexDirection: "row",
    justifyContent: "space",
    alignItems: "stretch",
    borderBottomWidth: 2,
    borderBottomColor: "#C1C1C1",
    backgroundColor: "#eef0fa",
  },
  cell: {
    flex: 1,
    paddingVertical: 5,
    textAlign: "center",
    fontSize: 8,
    fontWeight: "800",
    borderRightWidth: 2,
    borderBottomColor: "#C1C1C1",
  },
  bold: {
    fontWeight: "bold",
    backgroundColor: "#DCDCDC",
  },
});

export default SearchResultTable;
