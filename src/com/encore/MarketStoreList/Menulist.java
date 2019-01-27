package com.encore.MarketStoreList;

import java.util.ArrayList;
import java.util.Arrays;

public class Menulist {

	public static ArrayList<String> menulist(Object[] object) {
		// 계절에 따른 메뉴
		ArrayList<String> springmenu = new ArrayList<String>(Arrays.asList("한정식", "철판구이", "낙지", "오리", "지중해음식", "전",
				"불고기", "갈비살", "차돌박이", "딤섬", "비빔밥", "돌솥밥", "차돌박이", "딤섬", "나물", "냉이된평일장국"));
		ArrayList<String> summermenu = new ArrayList<String>(Arrays.asList("햄버거", "삼계탕", "냉면", "백숙", "찜닭", "아이스크림",
				"카레", "장어구이", "꼼장어", "전복", "치킨", "오리고기", "포장마차", "팥빙수", "과일화채", "비빔냉면", "콩국수"));
		ArrayList<String> fallmenu = new ArrayList<String>(
				Arrays.asList("맥주", "호프", "브런치", "딤섬", "바", "설렁탕", "곰탕", "도가니탕", "동남아음식", "순두부", "태국음식"));
		ArrayList<String> wintermenu = new ArrayList<String>(Arrays.asList("회", "해물탕", "해물요리", "꽃게", "쌀국수", "사케", "칵테일",
				"바", "씨푸드", "동남아음식", "와인", "스테이크", "오텡국", "콩나물국밥", "짬뽕", "만둣국", "육개장"));
		// 휴일 여부에 따른 메뉴
		ArrayList<String> Weekend = new ArrayList<String>(
				Arrays.asList("뷔페", "씨푸드", "햄버거", "돈가스", "전복", "동남아", "분식", "피자", "딤섬", "치킨"));
		ArrayList<String> weekday = new ArrayList<String>(Arrays.asList("순대국", "감자탕", "설렁탕", "곰탕", "도가니탕", "소주", "포장마차",
				"베이커리", "제과점", "찌개", "전골", "국", "탕", "맥주", "호프", "삼계탕", "백숙", "찜닭", "남미"));
		// 강수 여부에 따른 메뉴
		ArrayList<String> rain = new ArrayList<String>(Arrays.asList("포장마차", "파전", "전", "삼계탕", "백숙", "찜닭", "철판구이",
				"볶음밥", "중국음식", "오리", "곱창", "사케", "쌀국수", "뷔페", "칼국수"));
		// 적설 여부에 따른 메뉴
		ArrayList<String> snow = new ArrayList<String>(
				Arrays.asList("삼겹살", "목살", "이태리레스토랑", "설렁탕", "곰탕", "도가니탕", "바", "와인", "프렌치", "패밀리", "지중해", "동남아"));
		// 최종 메뉴
		ArrayList<String> resultmenu = new ArrayList<>();

		String season = (String) object[0];
		boolean isRain = (boolean) object[1];
		boolean isSnow = (boolean) object[2];
		String day = (String) object[3];

		if (day.equals("토") || day.equals("일")) {
			resultmenu.addAll(Weekend);
		} else {
			resultmenu.addAll(weekday);
		}
		if (isRain == true) {
			for (int i = 0; i < rain.size(); i++) {
				if (!resultmenu.contains(rain.get(i))) {
					resultmenu.add(rain.get(i));
				}
			}
		}
		if (isSnow == true) {
			for (int i = 0; i < snow.size(); i++) {
				if (!resultmenu.contains(snow.get(i))) {
					resultmenu.add(snow.get(i));
				}
			}
		}
		switch (season) {
		case "spring":
			for (int i = 0; i < springmenu.size(); i++) {
				if (!resultmenu.contains(springmenu.get(i))) {
					resultmenu.add(springmenu.get(i));
				}
			}
			break;
		case "summer":
			for (int i = 0; i < summermenu.size(); i++) {
				if (!resultmenu.contains(summermenu.get(i))) {
					resultmenu.add(summermenu.get(i));
				}
			}
			break;
		case "fall":
			for (int i = 0; i < fallmenu.size(); i++) {
				if (!resultmenu.contains(fallmenu.get(i))) {
					resultmenu.add(fallmenu.get(i));
				}
			}
			break;
		case "winter":
			for (int i = 0; i < wintermenu.size(); i++) {
				if (!resultmenu.contains(wintermenu.get(i))) {
					resultmenu.add(wintermenu.get(i));
				}
			}
			break;
		}

		return resultmenu;

	}

	public static void main(String[] args) {
		Object[] object = { "fall", false, false, "" };
		ArrayList<String> list = menulist(object);
		for (String a : list) {
			System.out.println(a);
			

		}
		System.out.println(list.size());
	}
}