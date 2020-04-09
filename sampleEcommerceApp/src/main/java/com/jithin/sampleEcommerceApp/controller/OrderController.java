package com.jithin.sampleEcommerceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jithin.sampleEcommerceApp.form.OrderForm;
import com.jithin.sampleEcommerceApp.model.Order;
import com.jithin.sampleEcommerceApp.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Get All orders
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
//			System.out.println("HIT SERVER");
		return orderService.getAllOrders();
	}

	// Create a new order
	@PostMapping("/orders")
	public Order createOrder(@Valid @RequestBody OrderForm orderForm) {
		return orderService.createOrder(orderForm);

	}

	// Get a Single Order
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable(value = "id") Long orderId) {
		return orderService.getOrderById(orderId);
	}

	// Update an order
	@PutMapping("/orders/{id}")
	public Order updateOrder(@PathVariable(value = "id") Long orderId, @Valid @RequestBody OrderForm orderForm) {
		return orderService.updateOrder(orderId, orderForm);
	}

	// Delete an order
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Long orderId) {
		return orderService.deleteOrder(orderId);
	}

	@PutMapping("/orders/{id}/changeStatus/paid")
	public Order changeStatusToPaid(@PathVariable(value = "id") Long orderId) {
		return orderService.changeStatusToPaid(orderId);
	}

	@PutMapping("/orders/{id}/changeStatus/delivered")
	public Order changeStatusToDelivered(@PathVariable(value = "id") Long orderId) {
		return orderService.changeStatusToDelivered(orderId);
	}

}
