import { View, Text, Alert, TouchableOpacity } from "react-native";
import React from "react";
import Table from "./Table";

const ShowInfos = ({ user }) => {
  return (
    <Table.Row>
      <Text>ID: {user.tc}</Text>
      <Text>Month: {user.month}</Text>
      <Text className="text-sm">
        Email: {"  "}
        {user.email}
      </Text>
      <Text>Birth: {user.birthDate}</Text>

      <TouchableOpacity
        style={{
          flexDirection: "row",
          alignItems: "center",
          paddingVertical: 8,
          borderBottomWidth: 1,
          borderBottomColor: "#ccc",
          backgroundColor: "red", // Aktif satır için arka plan rengi
        }}
        onPress={() => setShowInfo(!showInfo)}
      >
        <Text>Delete</Text>
      </TouchableOpacity>
    </Table.Row>
  );
};

export default ShowInfos;

// "tc": "admin",
// "month": 295,
// "email": null,
// "birthDate": "2000-05-04"
