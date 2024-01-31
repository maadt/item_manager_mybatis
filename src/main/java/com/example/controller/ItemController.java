package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	//新規登録ページでカテゴリーをリスト表示させるためのメソッド
	@GetMapping("/create")
	public String showCreate(@ModelAttribute ItemForm itemForm, Model model) {
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		return "create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute ItemForm itemForm) {
		this.itemService.insert(itemForm.getName(), itemForm.getPrice(), itemForm.getCategoryId());
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") Integer id, Model model
			                 , @ModelAttribute("itemForm") ItemForm itemForm) {
		Item item = this.itemService.findById(id);
		itemForm.setName(item.getName());
		itemForm.setPrice(item.getPrice());
		itemForm.setCategoryId(item.getCategoryId());
		List<Category> categories = this.categoryService.findAll();
		model.addAttribute("categories", categories);
		return "edit";
	}
}