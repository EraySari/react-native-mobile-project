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

//Here, instead of two different components(add, edit), the editValues ​​value could be checked and the operation could be done and we would use 1 component.
export async function editReference(data) {
  const inputData = {
    igA: data.igG,
    igM: data.igM,
    igG: data.igG,
    igG1: data.igG1,
    igG2: data.igG2,
    igG3: data.igG3,
    igG4: data.igG4,
    user: { id: data.userID },
    date: data.date,
  };

  const res = await fetch(`http://10.0.2.2:7071/api/analysis/${data.refId}`, {
    method: "PUT",
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
