import { Alert } from "react-native";

export async function getReferenceByName(data) {
  const res = await fetch(
    `http://10.0.2.2:7071/api/analysis/user/${data.name}/${data.surname}/analysis`,
    {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${data.basicAuth}`,
      },
    }
  );

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const references = await res.json();

  console.log(references);

  return references;
}

export async function addReference(data) {
  const inputData = {
    igA: data.igG,
    igM: data.igM,
    igG: data.igG,
    igG1: data.igG1,
    igG2: data.igG2,
    igG3: data.igG3,
    igG4: data.igG4,
    user: { id: data.id },
  };

  console.log("8888888888888888888888888", inputData);
  const res = await fetch("http://10.0.2.2:7071/api/analysis", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${data.basicAuth}`,
    },
    body: JSON.stringify(inputData),
  });
  if (!res.ok) {
    // Alert.alert(`${res.status} - ${res.statusText}`);
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  return res.json();
}
