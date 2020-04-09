package com.jithin.sampleEcommerceApp.form;

import com.sun.istack.NotNull;

public class OrderItemForm {

	@NotNull
	private Long ItemId;

	@NotNull
	private Integer quantity;

	public OrderItemForm(Long itemId, Integer quantity) {
		super();
		ItemId = itemId;
		this.quantity = quantity;
	}

	public OrderItemForm() {
	}

	public Long getItemId() {
		return ItemId;
	}

	public void setItemId(Long itemId) {
		ItemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
