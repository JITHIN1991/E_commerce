package com.jithin.sampleEcommerceApp.view;

import java.util.List;

import com.jithin.sampleEcommerceApp.model.Order;
import com.jithin.sampleEcommerceApp.model.OrderItem;

public class OrderView {

	private Long id;
	private String userName;
	private String emailId;
	private List<OrderItem> orderItems;
	private Long totalAmount;
	private Byte status;

	public OrderView(Long id, String userName, String emailId, List<OrderItem> orderItems, Long totalAmount,
			Byte status) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.orderItems = orderItems;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public OrderView(Order order) {
		super();
		this.id = order.getId();
		this.userName = order.getUserName();
		this.emailId = order.getEmailId();
		this.orderItems = order.getOrderItems();
		this.totalAmount = order.getTotalAmount();
		this.status = order.getOrderStatus().getValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
