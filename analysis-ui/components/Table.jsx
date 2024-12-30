import React, { createContext, useContext } from "react";
import { View, Text, StyleSheet } from "react-native";

const TableContext = createContext(); //column a digerlerinin erisebilmesi icin cunku hepsi ayri component hepsine ayri prop gecmek mantiksiz

function Table({ children, column }) {
  return (
    <TableContext.Provider value={{ column }}>
      <View style={styles.table}>{children}</View>
    </TableContext.Provider>
  );
}

function Header({ children }) {
  const { column } = useContext(TableContext);

  return (
    <View style={styles.row}>
      {column.map((flexValue, index) => (
        <View key={index} style={{ flex: flexValue }}>
          <Text style={styles.headerText}>{children[index]}</Text>
        </View>
      ))}
    </View>
  );
}

function Row({ children }) {
  const { column } = useContext(TableContext);

  return (
    <View style={styles.row}>
      {column.map((flexValue, index) => (
        <View key={index} style={{ flex: flexValue }}>
          <Text>{children[index]}</Text>
        </View>
      ))}
    </View>
  );
}

function Body({ children }) {
  return <View>{children}</View>;
}

Table.Header = Header;
Table.Row = Row;
Table.Body = Body;

export default Table;

const styles = StyleSheet.create({
  table: {
    borderWidth: 1,
    borderColor: "#D1D5DB",
    borderRadius: 8,
    overflow: "hidden",
    backgroundColor: "#f0f4f8",
    marginBottom: 16,
  },
  header: {
    flexDirection: "row",
    borderBottomWidth: 1,
    borderBottomColor: "#D1D5DB",
    backgroundColor: "#e5e7eb",
    padding: 16,
  },
  headerText: {
    textTransform: "uppercase",
    fontWeight: "bold",
    fontSize: 14,
    color: "#6B7280",
  },
  row: {
    flexDirection: "row",
    borderBottomWidth: 1,
    borderBottomColor: "#D1D5DB",
    paddingVertical: 16,
    paddingHorizontal: 16,
  },
});
