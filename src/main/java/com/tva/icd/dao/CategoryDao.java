package com.tva.icd.dao;

import java.util.List;

import com.tva.icd.model.Category;

public interface CategoryDao {
	
	public void addCategory(Category category);
	public List<Category> getAllCategory();
	public void deleteCategory(Integer categoryId);
	public Category updateCategory(Category category);
	public Category getCategory(Integer categoryId);
	public List<Category> getCategoryByGroup(Integer groupId);
	public List<Category> getCategoryLike(String column, String value);
}
