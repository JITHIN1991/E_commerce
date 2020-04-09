package com.jithin.sampleEcommerceApp.view;

import com.jithin.sampleEcommerceApp.model.Item;

public class ItemView {

	private String name;

	private Long price;

	private Long stock;

	private String imageUrl;

	public ItemView(String name, Long price, Long stock, String imageUrl) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
	}

	public ItemView(Item item) {
		super();
		this.name = item.getName();
		this.price = item.getPrice();
		this.stock = item.getStock();
		this.imageUrl = item.getImageUrl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
