import React, { useEffect, useState } from "react";
import {
  View,
  Text,
  TextInput,
  StyleSheet,
  Alert,
  ScrollView,
} from "react-native";

import CustomButton from "../../components/CustomButton";
import CustomLabel from "../../components/CustomLabel";
import { SafeAreaView } from "react-native-safe-area-context";

import { useAuth } from "../../context/authContext";
import useGetbyName from "../useApiReference/useGetbyName";
import Table from "../../components/Table";
import ResultRow from "../../components/ResultRow";
import useFindByMonth from "../useApiValues/useFindByMonth";
import useGetGuide from "../useApiValues/useGetGuide";

const Create = () => {
  const [loading, setLoading] = useState(true);

  const { getUser } = useAuth();

  const [user, setUser] = useState(null); // localden gelen admin verileri buna kaydediliyor

  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [result, setResult] = useState([]);
  const [allTypes, setAllTypes] = useState([]);
  const [valueByMonth, setValueByMonth] = useState([]);
  const [byGuideType, setByGuideType] = useState([]);

  const { searchMutate, isSearching } = useGetbyName();

  const { findMonthMutate, isFetcing } = useFindByMonth();

  const { guideMutate } = useGetGuide();

  useEffect(() => {
    // localden admin aliniyor
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

  function groupedDatabyGuideType(data) {
    return data?.reduce((acc, item) => {
      if (!acc[item.guideType]) {
        acc[item.guideType] = [];
      }
      acc[item.guideType].push(item);

      return acc;
    }, {});
  }

  const handleSave = () => {
    console.log("++++++++++++++++++++++fgfghfgh+", result);
    const dataPacket = {
      basicAuth: user.basicAuth,
      name: name,
      surname: surname,
    };
    searchMutate(dataPacket, { onSuccess: (data) => setResult(data) });
    console.log("++++++++++++++++++++++fgfghfgh+", {
      ...user,
      month: result[0].user?.month,
    });
    guideMutate(user, {
      onSuccess: (data) => {
        setAllTypes(data);
      },
    });
    findMonthMutate(
      { ...user, month: result[0].user?.month },
      {
        onSuccess: (data) => {
          setValueByMonth(data);
          const guide = groupedDatabyGuideType(data);
          setByGuideType(guide);
        },
      }
    );
  };

  if (loading) {
    return (
      <View>
        <Text>yükleniyor</Text>
      </View>
    );
  }

  return (
    <SafeAreaView className="h-full">
      <ScrollView className="flex-1 p-10">
        <View className=" w-full justify-center">
          <Text className="font-pbold text-2xl mb-9 text-center">
            User Information
          </Text>

          <CustomLabel>Name</CustomLabel>
          <TextInput
            style={styles.input}
            value={name}
            onChangeText={(text) => setName(text)}
          />
          {/* Soyad */}
          <CustomLabel>Surname</CustomLabel>
          <TextInput
            style={styles.input}
            value={surname}
            onChangeText={(text) => setSurname(text)}
          />

          {/* Kaydet Butonu */}
          <View style={styles.buttonContainer}>
            <CustomButton
              title="Search"
              handlePress={handleSave}
              disabled={loading}
            />
          </View>
        </View>

        <View>
          <Table column={[1, 1, 1, 1, 1, 1, 1, 1]}>
            <Table.Body>
              {result?.map((ref) => {
                return <ResultRow refData={ref} guideData={byGuideType} />;
              })}
            </Table.Body>
          </Table>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    borderColor: "#ccc",
    borderWidth: 1,
    borderRadius: 5,
    paddingHorizontal: 10,
    marginBottom: 15,
    backgroundColor: "#fff",
  },
  buttonContainer: {
    marginTop: 20,
    marginBottom: 35,
  },
});

export default Create;

//getMe kullanma guncellerken. Localden aldigin veri yukarda var güncellenmis hali onun kullan. Yeni bir useUpdate kullan onu kullan direkt yukardakini yolla
