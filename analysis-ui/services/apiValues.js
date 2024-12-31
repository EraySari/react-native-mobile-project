export async function getGuideType(data) {
  console.log("bbbbbbbbbbbbbb,", data);
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
  console.log("geeeeeeeeeeeeeeeeee,", data);
  //datada hem admin hem month gelecek
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

  return results;
}

// ilk olarak guideType cek. Örnegin elimde 5 type var 5 farkli karsilastirma olacak
// find with month ile veriyi cek. Her birinin guide typeina bak ve kendi kategorisine ekleyip tabloda göster
// daha sonra herbirinin calculateTypelere bak, sonra ona göre veriyi yukari mi asagi mi sorgula
