package com.encore.MarketStoreList;

public class StoreInfoDTO {
	private String img;
	private String category;
	private String name;
	private String link;
	private String addr;
	private String tel;
	private String price;
	private String openinghours;
	private double distance;

	public StoreInfoDTO() {

	}

	public StoreInfoDTO(String img, String category, String name, String link) {
		super();
		this.img = img;
		this.category = category;
		this.name = name;
		this.link = link;
	}

	public StoreInfoDTO(String img, String name, String addr, String tel, String price, String openinghours) {
		super();
		this.img = img;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.price = price;
		this.openinghours = openinghours;
	}

	public StoreInfoDTO(String img, String category, String name, String link, String addr, String tel, String price,
			String openinghours, double distance) {
		super();
		this.img = img;
		this.category = category;
		this.name = name;
		this.link = link;
		this.addr = addr;
		this.tel = tel;
		this.price = price;
		this.openinghours = openinghours;
		this.distance = distance;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOpeninghours() {
		return openinghours;
	}

	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "StoreInfoDTO [img=" + img + ", category=" + category + ", name=" + name + ", link=" + link + ", addr="
				+ addr + ", tel=" + tel + ", price=" + price + ", openinghours=" + openinghours + ", distance="
				+ distance + "]";
	}

}