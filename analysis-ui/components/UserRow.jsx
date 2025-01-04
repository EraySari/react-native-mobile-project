import { View, Text, TouchableOpacity, Alert } from "react-native";
import React, { useState } from "react";
import Table from "./Table";
import ShowInfos from "./ShowInfos";

const UserRow = ({ users, authdata }) => {
  const [showInfo, setShowInfo] = useState(false);

  return (
    <TouchableOpacity onPress={() => setShowInfo(!showInfo)}>
      <Table.Row>
        <Text>{users.name}</Text>
        <Text>{users.surname}</Text>
        <Text>{users.id}</Text>
        <Text>{users.birthDate?.split("-")[0]}</Text>
        <Text>{users.gender}</Text>
      </Table.Row>
      {showInfo && <ShowInfos user={users} authdata={authdata} />}
    </TouchableOpacity>
  );
};

export default UserRow;
