package com.jithin.sampleEcommerceApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jithin.sampleEcommerceApp.exception.OutOfStockException;
import com.jithin.sampleEcommerceApp.exception.ResourceNotFoundException;
import com.jithin.sampleEcommerceApp.form.OrderForm;
import com.jithin.sampleEcommerceApp.form.OrderItemForm;
import com.jithin.sampleEcommerceApp.model.Item;
import com.jithin.sampleEcommerceApp.model.Order;
import com.jithin.sampleEcommerceApp.model.OrderItem;
import com.jithin.sampleEcommerceApp.model.OrderItemPK;
import com.jithin.sampleEcommerceApp.repository.OrderItemRepository;
import com.jithin.sampleEcommerceApp.repository.OrderRepository;
import com.jithin.sampleEcommerceApp.util.OrderStatus;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemService itemService;

//	@Autowired
//	private OrderItemRepository orderItemRepository;

	// Get All orders
	public List<Order> getAllOrders() {
//		System.out.println("HIT SERVER");
		return orderRepository.findAll();
	}

	// Create a new order
	public Order createOrder(OrderForm orderForm) {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<>();
		order.setEmailId(orderForm.getEmailId());
		order.setOrderStatus(OrderStatus.NEW);
		order.setUserName(orderForm.getUserName());
		Long totalAmount = 0L;
		for (OrderItemForm orderItemForm : orderForm.getOrderItems()) {
			if (!itemService.itemExistOrNotById(orderItemForm.getItemId())) {
				throw new ResourceNotFoundException("Item does not exist");
			}

			Item item = itemService.getItemById(orderItemForm.getItemId());

			if (item.getStock() < orderItemForm.getQuantity()) {

				throw new OutOfStockException("The product - " + item.getName() + " is out of stock");
			}
			OrderItem orderItem = new OrderItem();
			OrderItemPK pk = new OrderItemPK();
			pk.setItem(item);
			pk.setOrder(order);
			orderItem.setOrderItemPK(pk);
			orderItem.setQuantity(orderItemForm.getQuantity());
			orderItems.add(orderItem);

			totalAmount = totalAmount + (item.getPrice() * orderItemForm.getQuantity());
		}
		order.setTotalAmount(totalAmount);
		order.setOrderItems(orderItems);

		return orderRepository.save(order);

	}

	// Get a Single Order
	public Order getOrderById(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
	}

	// Update an order
	public Order updateOrder(Long orderId, OrderForm orderForm) {

		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

		List<OrderItem> orderItems = new ArrayList<>();
		order.setEmailId(orderForm.getEmailId());
		order.setUserName(orderForm.getUserName());
		order.setOrderItems(null);
		Long totalAmount = 0L;
		for (OrderItemForm orderItemForm : orderForm.getOrderItems()) {
			if (!itemService.itemExistOrNotById(orderItemForm.getItemId())) {
				throw new ResourceNotFoundException("Item does not exist");
			}
			Item item = itemService.getItemById(orderItemForm.getItemId());

			if (item.getStock() < orderItemForm.getQuantity()) {
				throw new OutOfStockException("The product - " + item.getName() + " is out of stock");

			} else {
				item.setStock((item.getStock()) - orderItemForm.getQuantity());
			}

			OrderItem orderItem = new OrderItem();
			OrderItemPK pk = new OrderItemPK();
			pk.setItem(item);
			pk.setOrder(order);
			orderItem.setOrderItemPK(pk);
			orderItem.setQuantity(orderItemForm.getQuantity());
			orderItems.add(orderItem);

			totalAmount = totalAmount + (item.getPrice() * orderItemForm.getQuantity());
		}
		order.setTotalAmount(totalAmount);
		order.setOrderItems(orderItems);

		Order updatedOrder = orderRepository.save(order);
		return updatedOrder;
	}

	// Delete a Item
	public ResponseEntity<?> deleteOrder(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

		orderRepository.delete(order);

		return ResponseEntity.ok().build();
	}

//  change status to paid
	public Order changeStatusToPaid(Long orderId) {

		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

		order.setOrderStatus(OrderStatus.PAID);
		return orderRepository.save(order);
	}

//    change status to delivered
	public Order changeStatusToDelivered(Long orderId) {

		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

		order.setOrderStatus(OrderStatus.DELIVERED);
		return orderRepository.save(order);
	}

}
