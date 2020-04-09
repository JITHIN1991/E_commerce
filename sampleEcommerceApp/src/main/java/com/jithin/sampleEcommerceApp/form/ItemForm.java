package com.jithin.sampleEcommerceApp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemForm {

	@NotBlank(message = "Name may not be null")
	private String name;

	@NotNull(message = "price may not be null")
	private Long price;

	@NotNull(message = "quantity may not be null")
	private Long stock;

	private String imageUrl;

	public ItemForm() {
	}

	public ItemForm(@NotBlank(message = "Name may not be null") String name,
			@NotNull(message = "price may not be null") Long price,
			@NotNull(message = "quantity may not be null") Long stock, String imageUrl) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.imageUrl = imageUrl;
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
