package com.jithin.sampleEcommerceApp.form;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class OrderForm {

	@NotBlank(message = "User-name may not be null")
	private String userName;
	@NotBlank(message = "Email may not be null")
	@Email(message = "Email is not valid")
	private String emailId;

	@NotEmpty
	private List<OrderItemForm> orderItems;

	public OrderForm() {

	}

	public OrderForm(@NotBlank(message = "User-name may not be null") String userName,
			@NotBlank(message = "Email may not be null") @Email(message = "Email is not valid") String emailId,
			@NotEmpty List<OrderItemForm> orderItems) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.orderItems = orderItems;
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

	public List<OrderItemForm> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemForm> orderItems) {
		this.orderItems = orderItems;
	}

}
