package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.entity.Category;
import com.example.entity.Item;
import com.example.form.ItemForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
public class ItemController {
	private final ItemService itemService;
	private final CategoryService categoryService;
	
	@Autowired
	public ItemController(ItemService itemService, CategoryService categoryService) {
		this.itemService = itemService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Item> items = this.itemService.findAll();
		model.addAttribute("items", items);
		return "index";
	}
	
	//カテゴリーを一覧表示させるためのメソッド
	@GetMapping("/create")
	public String showCreate(@ModelAttribute ItemForm itemForm, Model model) {
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		return "create";
	}
}
