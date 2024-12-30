import { View, Text, ScrollView } from "react-native";
import React from "react";
import Table from "../../components/Table";
import { SafeAreaView } from "react-native-safe-area-context";

const Results = () => {
  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-10">
        <View className="min-h-[70vh] w-full justify-center">
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
