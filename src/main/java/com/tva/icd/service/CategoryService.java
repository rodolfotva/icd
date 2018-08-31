package com.tva.icd.service;

import java.util.List;

import com.tva.icd.model.Category;

public interface CategoryService {

	public void addCategory(Category category);

	public List<Category> getAllCategorys();

	public void deleteCategory(Category category);

	public Category updateCategory(Category category);

	public Category getCategory(String objectId);

	public Category getCategoryById(String id);

	public List<Category> getCategoryByChapterId(String chapterObjId, String locale);

}
