package com.jithin.sampleEcommerceApp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class OrderItemPK implements Serializable {

	@JsonBackReference
	@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;

	
	@ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id")
	private Item item;

	public OrderItemPK() {

	}

	public OrderItemPK(Order order, Item item) {
		super();
		this.order = order;
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
