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

import com.jithin.sampleEcommerceApp.form.ItemForm;
import com.jithin.sampleEcommerceApp.model.Item;
import com.jithin.sampleEcommerceApp.service.ItemService;
import com.jithin.sampleEcommerceApp.view.ItemView;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService itemService;

	// Get All Items
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	// Create a new Item
	@PostMapping("/items")
	public ItemView createItem(@Valid @RequestBody ItemForm itemForm) {
		return new ItemView(itemService.createItem(itemForm));
	}

	// Get a Single item
	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable(value = "id") Long itemId) {
		return itemService.getItemById(itemId);
	}

	// Update an item
	@PutMapping("/items/{id}")
	public Item updateItem(@PathVariable(value = "id") Long itemId, @Valid @RequestBody ItemForm itemForm) {

		return itemService.updateItem(itemId, itemForm);

	}

	// Update stock
	@PutMapping("/items/{id}/add-stock/{quantity}")
	public Item updateQuantity(@PathVariable(value = "id") Long itemId,
			@PathVariable(value = "quantity") Long quantity) {

		return itemService.updateQuantity(itemId, quantity);

	}

	// Delete a Item
	@DeleteMapping("/items/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "id") Long itemId) {
		return itemService.deleteItem(itemId);
	}

}
