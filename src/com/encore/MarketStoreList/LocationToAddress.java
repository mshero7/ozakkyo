package com.encore.MarketStoreList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationToAddress {
	public static void main(String[] args) throws IOException {
		String x = "127.423084873712";
		String y = "37.0789561558879";

		String strUrl = "https://dapi.kakao.com/v2/local/geo/coord2address.json?" + "x=" + x + "&y=" + y
				+ "&input_coord=WGS84";
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Host", "dapi.kakao.com");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "KakaoAK 0d81315a4dac4305692329cf0b88f02e");
		conn.setRequestMethod("GET");

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300)
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		else
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		JSONObject obj = new JSONObject(sb.toString());
		Object[] path = { "documents", 0 };
		obj = (JSONObject) getObject(obj, path);
		Object addr = obj.getJSONObject("address").get("address_name");
		System.out.println("address = " + addr);
		
		
		
	}

	public static Object getObject(JSONObject obj, Object[] path) {
		Object tmp = null;

		for (Object p : path)
			if (p instanceof String)
				if (obj.get((String) p) instanceof JSONArray)
					tmp = (JSONArray) obj.get((String) p);
				else
					tmp = (JSONObject) obj.get((String) p);
			else
				tmp = ((JSONArray) tmp).get((Integer) p);

		return tmp;
	}
}