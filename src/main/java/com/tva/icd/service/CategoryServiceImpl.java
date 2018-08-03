package com.tva.icd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.dao.CategoryDao;
import com.tva.icd.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	@Transactional
	public List<Category> getAllCategorys() {
		return categoryDao.getAllCategory();
	}

	@Override
	@Transactional
	public void deleteCategory(Integer categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

	@Override
	@Transactional
	public Category updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	@Transactional
	public Category getCategory(Integer categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	@Override
	@Transactional
	public List<Category> getCategoryByGroup(Integer groupId) {
		return categoryDao.getCategoryByGroup(groupId);
	}

	@Override
	public List<Category> getCategoryLike(String column, String value) {
		return categoryDao.getCategoryLike(column, value);
	}

}
