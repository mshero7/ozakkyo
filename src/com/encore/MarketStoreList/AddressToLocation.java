package com.encore.MarketStoreList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AddressToLocation {
	public double[] MakeLocation(String address) throws IOException {
		String strUrl = "https://dapi.kakao.com/v2/local/search/address.json?query="
				+ URLEncoder.encode(address, "utf-8");
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
		// System.out.println(obj);
		double x = obj.getDouble("x");
		double y = obj.getDouble("y");
		// System.out.println("x: " + x + "\ty: " + y);

		double[] location = { x, y };
		return location;

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