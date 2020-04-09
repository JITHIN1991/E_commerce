package com.jithin.sampleEcommerceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jithin.sampleEcommerceApp.model.OrderItem;
import com.jithin.sampleEcommerceApp.model.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
