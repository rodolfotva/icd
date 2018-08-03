package com.tva.icd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage(){
		System.out.println("loading index page");
		return "index";
	}
	
	@RequestMapping(value="donation", method = RequestMethod.GET)
	public String getDonationPage(){
		System.out.println("loading donation page");
		return "donation";
	}
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public String getSearchPage(){
		System.out.println("loading search page");
		return "search";
	}
	
	@RequestMapping(value="classification", method = RequestMethod.GET)
	public String getClassificationPage(){
		System.out.println("loading classification page");
		return "classification";
	}
	
	@RequestMapping(value="chapter", method = RequestMethod.GET)
	public String getChapterPage(){
		System.out.println("loading chapter page");
		return "chapter";
	}
	
	@RequestMapping(value="group", method = RequestMethod.GET)
	public String getGroupPage(){
		System.out.println("loading group page");
		return "group";
	}
	
	@RequestMapping(value="category", method = RequestMethod.GET)
	public String getCategoryPage(){
		System.out.println("loading category page");
		return "category";
	}
}
