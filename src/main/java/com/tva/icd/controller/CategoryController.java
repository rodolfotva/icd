package com.tva.icd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.icd.model.Category;
import com.tva.icd.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		System.out.println("Starting category controller");
	}

	@RequestMapping(value = "/category/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> listAllCategorys() {
		
		System.out.println("listAllCategorys ResponseEntity");
		List<Category> category = categoryService.getAllCategorys();

		if (category.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);

	}

	@RequestMapping(value = "/category/{chapterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategory(@PathVariable("chapterId") Integer chapterId) {
		System.out.println("Fetching Category with id " + chapterId);
		List<Category> category = categoryService.getCategoryByGroup(chapterId);
		
		if (category.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/{column}/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategoryLike(@PathVariable("column") String column, @PathVariable("value") String value) {
		System.out.println("Fetching Category with " + column +": "+ value);
		List<Category> category = categoryService.getCategoryLike(column, value);
		category.stream().forEach(group -> System.out.println(group.toString()));
		
		if (category.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
	}

}