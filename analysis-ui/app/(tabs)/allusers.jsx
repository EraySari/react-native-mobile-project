import { ScrollView, StyleSheet, Text, View } from "react-native";
import React, { useEffect, useState } from "react";
import useGetUsers from "../useApiUsers/useGetUsers";
import { useAuth } from "../../context/authContext";
import Table from "../../components/Table";
import UserRow from "../../components/UserRow";
import { SafeAreaView } from "react-native-safe-area-context";

const AllUsers = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  const { getUser } = useAuth();

  useEffect(() => {
    // localden user aliniyor
    const fetchUser = async () => {
      try {
        setLoading(true);
        const jsonData = await getUser();
        setUser(jsonData);
      } catch (error) {
        console.error("error");
      } finally {
        setLoading(false);
      }
    };

    fetchUser();
  }, []);

  const { data, isPending } = useGetUsers(user);

  console.log(data);
  if (loading || isPending) {
    return (
      <View>
        <Text>Loading...</Text>
      </View>
    );
  }

  console.log(data);
  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-4">
        <View className=" w-full justify-center">
          <Text className="font-pbold text-2xl mb-1 text-center">
            All Users
          </Text>
          <Table column={[1, 1.4, 1, 1, 1]}>
            <Table.Header>
              <View>
                <Text>Name</Text>
              </View>
              <View>
                <Text>Surname</Text>
              </View>
              <View>
                <Text>ID</Text>
              </View>
              <View>
                <Text>Birth</Text>
              </View>
              <View>
                <Text>Gender</Text>
              </View>
            </Table.Header>
            <Table.Body>
              {data.map((users) => (
                <UserRow users={users} authdata={user.basicAuth} />
              ))}
            </Table.Body>
          </Table>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default AllUsers;

//admin user silebilecek
