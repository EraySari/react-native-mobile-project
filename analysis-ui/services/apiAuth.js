import { Alert } from "react-native";

// APIs about auth
export async function userLogin(tc, password) {
  const res = await fetch("http://10.0.2.2:7071/auth/authenticate", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ tc, password }),
  });

  if (!res.ok) {
    Alert.alert(`${res.status} - ${res.statusText}`);
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const data = await res.json();

  return { ...data, password: password };
}

export async function userSignup(data) {
  Alert.alert(JSON.stringify(data));
  const res = await fetch("http://10.0.2.2:7071/auth/signup", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) {
    // Alert.alert(`${res.status} - ${res.statusText}`);
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  return res.json();
}
