import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import React, { useState } from "react";
import { formatDate } from "../app/helpers/formatDate";
import ResultTablo from "./ResultTablo";
import prepareData from "../app/helpers/prepareData";
import CustomButton from "./CustomButton";
import AddRefForm from "./AddRefForm";

const ResultRow = ({ refData, guideData, userID, admin }) => {
  const [showInfo, setShowInfo] = useState(false);
  const [showEditInput, setShowEditInput] = useState(false);

  const userValues = {
    igA: refData.igA,
    igG: refData.igG,
    igG1: refData.igG1,
    igG2: refData.igG2,
    igG3: refData.igG3,
    igG4: refData.igG4,
    igM: refData.igM,
  };

  const results = prepareData(userValues, guideData);

  return (
    <>
      <TouchableOpacity
        onPress={() => {
          setShowInfo(!showInfo);
          {
            showEditInput && setShowEditInput(!showEditInput);
          }
        }}
      >
        <View className="py-4 border border-gray-300 ">
          <Text className="text-center mb-4">{formatDate(refData.date)}</Text>

          <View className="items-center">
            {showInfo && (
              <CustomButton
                title="Edit"
                containerStlyes="bg-blue-700 min-h-[35px] w-20"
                textStyles="font-plight text-sm "
                handlePress={() => setShowEditInput(!showEditInput)}
              />
            )}
          </View>
        </View>
      </TouchableOpacity>

      {showEditInput && (
        <AddRefForm
          user={userID}
          admin={admin}
          editValue={userValues}
          setShowEditInput={setShowEditInput}
          refData={refData.id}
        />
      )}

      {showInfo && !showEditInput && (
        <View style={styles.container}>
          <ResultTablo results={results} userValues={userValues} />
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
});
export default ResultRow;
