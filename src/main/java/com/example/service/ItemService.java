package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.mapper.ItemMapper;

@Service
public class ItemService {
	private final ItemMapper itemMapper;
	
	@Autowired
	public ItemService(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}
	
	public List<Item> findAll() {
		return this.itemMapper.findAll();
	}
	
	public void insert(ItemForm itemForm) {
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		item.setStock(0);	
		item.setCategoryId(itemForm.getCategoryId());
		this.itemMapper.insert(item);
	}
}