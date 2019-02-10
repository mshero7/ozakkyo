package com.encore.MarketStoreList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class StoreList {
	public static void makestorelist(String area, String menu) throws InterruptedException, IOException {
		// https://www.mangoplate.com/search/서초-한식
		List<StoreInfoDTO> storelist = new ArrayList<StoreInfoDTO>();
		List<String> links = new ArrayList<>();
		DistanceMeasurment measurment = new DistanceMeasurment();
		AddressToLocation addresstolocation = new AddressToLocation();

		String surl = "https://www.mangoplate.com/search/" + area + "%20" + menu;
		Document doc = Jsoup.connect(surl).get();
		
		Elements stores = doc.select(".list-restaurants .list-restaurant-item>.restaurant-item");

		// store 페이지수
//		for (Element store : stores) {
//			String link = store.select("figcaption>div.info>a").attr("href");
//			links.add(link);
//		}

		// store 1개
		for (int i = 0; i <= 0; i++) {
			String link = stores.get(i).select("figcaption>div.info>a").attr("href");
			links.add(link);
		}

		for (String link : links) {
			Document doc1 = Jsoup.connect("https://www.mangoplate.com" + link).get();

			// String name = doc1.select(".contents>.column-wrapper>.column-contents
			// .restaurant-detail .restaurant_title_wrap>.title>h1.restaurant_name").text();

			List<Element> info_table = doc1
					.select(".contents>.column-wrapper>.column-contents .restaurant-detail>table.info>tbody>tr");

//			String table = info_table.toString();
//			System.out.println(table);

			String img = null;
			String name = null;
			String category = null;
			String addr = null;
			double[] location = null;
			String tel = null;
			String price = null;
			String openinghours = null;
			double distance = 0.0;

			img = doc1.select("figure.list-photo > figure > img").attr("src");
			name = doc1.select("header>div.restaurant_title_wrap>span>h1.restaurant_name").text();
			for (int i = 0; i <= info_table.size() - 1; i++) {
				String a = info_table.get(i).text();
				if (a.contains("음식 종류")) {
					category = info_table.get(i).text();
				} else if (a.contains("주소")) {
					addr = info_table.get(i).text();
				} else if (a.contains("전화번호")) {
					tel = info_table.get(i).text();
				} else if (a.contains("가격대")) {
					price = info_table.get(i).text();
				} else if (a.contains("영업시간")) {
					openinghours = info_table.get(i).text();
				}
			}
			location = addresstolocation.MakeLocation(addr);
			distance = measurment.distance(location[0], location[1], 126.95866266369002, 37.56708018464179, "meter");
			// 거리조절
			if (distance <= 500.0) {
				StoreInfoDTO storeinfo = new StoreInfoDTO(img, category, name, link, addr, tel, price, openinghours,
						distance);
				System.out.println(storeinfo.toString());
				storelist.add(storeinfo);

			} else
				System.out.println("실패..\t" + distance);
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Menulist menulist = new Menulist();
		String area = "서대문구";
		Object[] object = { "fall", false, false, "" };
		ArrayList<String> list = menulist.menulist(object);
		for (String menu : list) {
			makestorelist(area, menu);
		}

//		for (String menu : list) {
//			List<StoreInfoDTO> storelist = makestorelist(area, menu);
//			System.out.println(menu);
//			// 객체list
//			for (StoreInfoDTO s : storelist) {
//				System.out.println(s);
//			}
//		}
		// json형식으로 만들기
//		Gson gson = new Gson();
//		for (StoreInfoDTO s : storelist) {
//			String jstore = gson.toJson(s);
//			System.out.println("json : " + jstore);
//		}
	}

}