package com.tva.icd.service;

import java.util.List;

import com.tva.icd.model.Category;

public interface CategoryService {

	public void addCategory(Category category);
	public List<Category> getAllCategorys();
	public void deleteCategory(Integer categoryId);
	public Category updateCategory(Category category);
	public Category getCategory(Integer categoryId);
	public List<Category> getCategoryByGroup(Integer groupId);
	public List<Category> getCategoryLike(String column, String value);
}
