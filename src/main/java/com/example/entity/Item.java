package com.example.entity;

import java.time.LocalDateTime;

public class Item {
	private int id;
	private String name;
	private int price;
	private int stock;
	private int categoryId;
	private LocalDateTime deletedAt;
	/*DBの型を「timestamp without time zone」に変更
	実行クエリ
	ALTER TABLE items
	ALTER COLUMN deleted_at TYPE timestamp without time zone
	USING deleted_at::timestamp without time zone;
	*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	private Category category;
	
	public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}