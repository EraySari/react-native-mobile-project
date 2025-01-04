export async function getGuideType(data) {
  const res = await fetch(`http://10.0.2.2:7071/api/values/guideTypes`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Basic ${data.basicAuth}`,
    },
  });

  if (!res.ok) {
    throw new Error(`${res.status} - ${res.statusText}`);
  }

  const types = await res.json();

  return types;
}

export async function findByMonth(data) {
  console.log("888888888888888888888888", data);
  const res = await fetch(
    `http://10.0.2.2:7071/api/values/month/${data.month}`,
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

  const results = await res.json();

  console.log("9999999999999999999", results);
  return results;
}
