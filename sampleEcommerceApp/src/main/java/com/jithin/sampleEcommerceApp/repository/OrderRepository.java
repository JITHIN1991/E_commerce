package com.jithin.sampleEcommerceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jithin.sampleEcommerceApp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
