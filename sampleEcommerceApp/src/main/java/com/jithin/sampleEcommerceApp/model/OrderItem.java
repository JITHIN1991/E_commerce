package com.jithin.sampleEcommerceApp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderItem {

	@EmbeddedId
	@JsonIgnore
	private OrderItemPK orderItemPK;

	@Column(nullable = false)
	private Integer quantity;

	public OrderItem() {

	}

	public OrderItem(Order order, Item item, Integer quantity) {

		orderItemPK = new OrderItemPK();
		orderItemPK.setOrder(order);
		orderItemPK.setItem(item);
		this.quantity = quantity;
	}

	@Transient
	public Item getItem() {
		return this.orderItemPK.getItem();
	}

	@Transient
	public Long getTotalPrice() {
		return getItem().getPrice() * getQuantity();
	}

	public OrderItemPK getOrderItemPK() {
		return orderItemPK;
	}

	public void setOrderItemPK(OrderItemPK orderItemPK) {
		this.orderItemPK = orderItemPK;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
