import { View, Text, TouchableOpacity, Alert } from "react-native";
import React, { useState } from "react";
import Table from "./Table";
import ShowInfos from "./ShowInfos";

const TableRow = ({ users }) => {
  console.log(users);
  const [showInfo, setShowInfo] = useState(false);

  return (
    <TouchableOpacity onPress={() => setShowInfo(!showInfo)}>
      <Table.Row>
        <Text>{users.name}</Text>
        <Text>{users.surname}</Text>
        <Text>{users.id}</Text>
        <Text>{users.birthDate?.split("-")[0]}</Text>
        <Text>{users.gender}</Text>

        <button className="bg-black-200">B</button>
      </Table.Row>
      {showInfo && <ShowInfos user={users} />}
    </TouchableOpacity>
  );
};

export default TableRow;
