import { View, Text, ScrollView } from "react-native";
import React from "react";
import Table from "../../components/Table";
import { SafeAreaView } from "react-native-safe-area-context";

const Results = () => {
  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-10">
        <View className="w-full justify-center">
          <Text className="font-pbold text-2xl mb-1 text-center">
            My Results
          </Text>
          <Table column={[1, 1, 1, 1, 1]}>
            <Table.Header>
              <View>Deneme</View>
              <View>deger</View>
              <View>a ara</View>
              <View>b arar</View>
              <View>c arar</View>
            </Table.Header>
            <Table.Body>
              <Table.Row>jnjs</Table.Row>
              <Table.Row>ss</Table.Row>
              <Table.Row>s</Table.Row>
            </Table.Body>
          </Table>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default Results;
