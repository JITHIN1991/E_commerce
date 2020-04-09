package com.jithin.sampleEcommerceApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jithin.sampleEcommerceApp.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
