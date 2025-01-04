import { Alert } from "react-native";

export async function getMe(user) {
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

  return allUsers;
}

export async function deleteUser(deleteUserData) {
  const res = await fetch(
    `http://10.0.2.2:7071/api/users/${deleteUserData.tc}`,
    {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Basic ${deleteUserData.authdata}`,
      },
    }
  );

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }
}
