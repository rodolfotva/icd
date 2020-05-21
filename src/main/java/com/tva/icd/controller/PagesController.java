package com.tva.icd.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/{locale:en|fr|pt}/")
public class PagesController {

  private static final Logger logger = LogManager.getLogger(PagesController.class.getName());

  @RequestMapping(method = RequestMethod.GET)
  public String getIndexPage() {
    logger.info("loading index locale page");
    return "index";
  }

  @RequestMapping(value = "donation", method = RequestMethod.GET)
  public String getDonationPage() {
    logger.info("loading donation page");
    return "donation";
  }

  @RequestMapping(value = "search", method = RequestMethod.GET)
  public String getSearchPage() {
    logger.info("loading search page");
    return "search";
  }

  @RequestMapping(value = "classification", method = RequestMethod.GET)
  public String getClassificationPage() {
    logger.info("loading classification page");
    return "classification";
  }

  @RequestMapping(value = "chapter", method = RequestMethod.GET)
  public String getChapterPage() {
    logger.info("loading chapter page");
    return "chapter";
  }

  @RequestMapping(value = "group", method = RequestMethod.GET)
  public String getGroupPage() {
    logger.info("loading group page");
    return "group";
  }

  @RequestMapping(value = "category", method = RequestMethod.GET)
  public String getCategoryPage() {
    logger.info("loading category page");
    return "category";
  }
}
