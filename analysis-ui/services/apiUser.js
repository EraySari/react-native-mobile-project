export async function getMe(user) {
  console.log("getMe: ", user);
  console.log(`Basic ${user.basicAuth}`);
  const res = await fetch("http://10.0.2.2:7071/api/users/me", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${user.basicAuth}`,
    },
  });
  if (!res.ok) {
    // Alert.alert(`${res.status} - ${res.statusText}`);
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const me = await res.json();
  return me;
}

export async function updateUser(user) {
  const { name, surname, password, email, gender } = user;
  console.log(`Basic ${user.basicAuth}`);
  console.log({ name, surname, password, email, gender });
  const res = await fetch("http://10.0.2.2:7071/api/users/updateMe", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${user.basicAuth}`,
    },
    body: JSON.stringify({ name, surname, password, email, gender }),
  });

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const updatedData = await res.json();

  return updatedData;
}

export async function getAllUsers(user) {
  console.log("Girdi");
  const res = await fetch("http://10.0.2.2:7071/api/users", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${user.basicAuth}`,
    },
  });

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const allUsers = await res.json();
  console.log(allUsers);

  return allUsers;
}

export async function deleteUser(user) {
  console.log("deleteeeee: ", user);
  const res = await fetch("http://10.0.2.2:7071/api/users", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${user.basicAuth}`,
    },
  });

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const allUsers = await res.json();
  console.log(allUsers);

  return allUsers;
}
