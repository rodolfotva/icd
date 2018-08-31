package com.tva.icd.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.model.Category;
import com.tva.icd.repositories.CategoryFrRepository;
import com.tva.icd.repositories.CategoryPtRepository;
import com.tva.icd.repositories.CategoryRepository;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private CategoryPtRepository categoryPtRepo;
	@Autowired
	private CategoryFrRepository categoryFrRepo;

	@Override
	public List<Category> getCategoryByChapterId(String chapterId, String locale) {
		switch (locale) {
		case "en":
			return categoryRepo.findByChapterid(chapterId);
		case "pt":
			List<Category> temp = new LinkedList<Category>();
			categoryPtRepo.findByChapterid(chapterId).stream().forEach(cat -> {
				temp.add(new Category(cat.getObjectId(), cat.getId(), cat.getFirst(), cat.getLast(), cat.getTitle(),
						cat.getChapterId()));
			});
			return temp;
		case "fr":
			List<Category> tempFr = new LinkedList<Category>();
			categoryFrRepo.findByChapterid(chapterId).stream().forEach(cat -> {
				tempFr.add(new Category(cat.getObjectId(), cat.getId(), cat.getFirst(), cat.getLast(), cat.getTitle(),
						cat.getChapterId()));
			});
			return tempFr;
		default:
			return categoryRepo.findByChapterid(chapterId);
		}
	}

	@Override
	public void addCategory(Category category) {

	}

	@Override
	public List<Category> getAllCategorys() {
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(Category category) {

	}

	@Override
	public Category updateCategory(Category category) {
		return null;
	}

	@Override
	public Category getCategory(String objectId) {
		return null;
	}

	@Override
	public Category getCategoryById(String id) {
		return null;
	}
}
