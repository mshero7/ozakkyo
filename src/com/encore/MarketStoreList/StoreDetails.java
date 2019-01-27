package com.encore.MarketStoreList;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class StoreDetails {
	public static StoreInfoDTO storedetails(String link) throws IOException {

		// category : 한식, 분식, 양식, 세계음식, 뷔페, 디저트, 카페, 술집, 치킨, 브런치, 이탈리안

		Document doc = Jsoup.connect(link).get();

		String img = doc.select(".contents>.restaurant-photos .owl-item>figure.list-photo>meta").attr("content");
		String name = doc.select(
				".contents>.column-wrapper>.column-contents .restaurant-detail .restaurant_title_wrap>.title>h1.restaurant_name")
				.text();
		List<Element> info_table = doc
				.select(".contents>.column-wrapper>.column-contents .restaurant-detail>table.info>tbody>tr");
		String addr = info_table.get(0).text();
		String tel = info_table.get(1).text();
		String price = info_table.get(3).text();
		String openinghours = info_table.get(5).text();
		StoreInfoDTO store = new StoreInfoDTO(img, name, addr, tel, price, openinghours);
		return store;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(storedetails("https://www.mangoplate.com/restaurants/0Vq0bf1rZJLZ"));

	}
}