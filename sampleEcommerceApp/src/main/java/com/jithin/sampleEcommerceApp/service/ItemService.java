package com.jithin.sampleEcommerceApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jithin.sampleEcommerceApp.exception.ResourceNotFoundException;
import com.jithin.sampleEcommerceApp.form.ItemForm;
import com.jithin.sampleEcommerceApp.model.Item;
import com.jithin.sampleEcommerceApp.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	// Get All Items
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	// Create a new Item
	public Item createItem(ItemForm itemForm) {
		Item item = new Item();
		item.setImageUrl(itemForm.getImageUrl());
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		item.setStock(itemForm.getStock());
		return itemRepository.save(item);
	}

	// Get a Single Note
	public Item getItemById(Long itemId) {
//		if(!itemExistOrNotById(itemId)) {
//			throw new ResourceNotFoundException("Item Not Found");
//		}
		return itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
	}
	
	public Boolean itemExistOrNotById(Long id) {
		return itemRepository.existsById(id);
	}

	// Update a Note
	public Item updateItem(Long itemId, ItemForm itemForm) {

		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));

		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		item.setStock(itemForm.getStock());
		item.setImageUrl(itemForm.getImageUrl());

		Item updatedItem = itemRepository.save(item);
		return updatedItem;
	}

	// Update a Note
	public Item updateQuantity(Long itemId, Long quantity) {

		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));

		item.setStock(item.getStock() + quantity);

		Item updatedItem = itemRepository.save(item);
		return updatedItem;
	}

	// Delete a Item
	public ResponseEntity<?> deleteItem(Long itemId) {
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));

		itemRepository.delete(item);

		return ResponseEntity.ok().build();
	}

}
