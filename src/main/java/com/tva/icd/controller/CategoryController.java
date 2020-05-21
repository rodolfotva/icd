package com.tva.icd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
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

  private static final Logger logger = LogManager.getLogger(CategoryController.class.getName());

  public CategoryController() {
    logger.info("Initializing Category Controller");
  }

  @RequestMapping(value = "/category/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Category>> listAllCategorys() {
    logger.info("listAllGroups ResponseEntity");
    List<Category> categoryLst = categoryService.getAllCategorys();

    if (Objects.isNull(categoryLst) || categoryLst.isEmpty()) {
      return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Categorys found: " + categoryLst.size());
    return new ResponseEntity<List<Category>>(categoryLst, HttpStatus.OK);

  }

  @RequestMapping(value = "/category/{chapterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> getCategoryLstByChapter(@PathVariable("chapterId") String chapterId) {
    logger.info("Fetching Categorys with Chapter Objectid " + chapterId);
    Map<String, Object> values = new HashMap<String, Object>();

    List<Category> categoryLst =
        categoryService.getCategoryByChapterId(chapterId, LocaleContextHolder.getLocale().getLanguage()).stream().sorted((u1, u2) -> u1.getId().compareTo(u2.getId())).collect(Collectors.toList());
    values.put("categoryLst", categoryLst);
    values.put("chapterObjId", chapterId);

    if (Objects.isNull(categoryLst) || categoryLst.isEmpty()) {
      logger.info("Category List from chapter id " + chapterId + " not found");
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Categorys found: " + categoryLst.size());
    return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
  }

}
