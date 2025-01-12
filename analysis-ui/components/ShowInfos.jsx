import { View, Text, TextInput, ScrollView } from "react-native";
import React, { useEffect, useState } from "react";
import Table from "./Table";
import useDeleteUser from "../app/useApiUsers/useDeleteUser";
import CustomButton from "./CustomButton";
import { useAuth } from "../context/authContext";
import AddRefForm from "./AddRefForm";

const ShowInfos = ({ user, authdata }) => {
  const { deleteMutate, isPending } = useDeleteUser();
  const [addTable, setAddTable] = useState(false);
  const [admin, setAdmin] = useState(null);
  const [loading, setLoading] = useState(true);
  const deleteUserData = { ...user, authdata: authdata };

  const { getUser } = useAuth();

  const handleDelete = () => {
    deleteMutate(deleteUserData);
  };

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

  if (loading) {
    return (
      <View>
        <Text>yükleniyor</Text>
      </View>
    );
  }

  return (
    <>
      <Table.Row>
        <Text>National ID: {user.tc}</Text>
        <Text>Month: {user.month}</Text>
        <Text className="text-sm">Email: {user.email}</Text>
        <Text>Birth: {user.birthDate}</Text>

        <View>
          <CustomButton
            title="Delete"
            handlePress={() => handleDelete()}
            disabled={isPending}
            textStyles="text-sm"
            containerStlyes="bg-red-500"
          />
          <CustomButton
            title="Add Ref"
            disabled={isPending}
            handlePress={() => setAddTable(!addTable)}
            textStyles="text-sm"
          />
        </View>
      </Table.Row>

      {addTable && <AddRefForm admin={admin} user={user} />}
    </>
  );
};

export default ShowInfos;
