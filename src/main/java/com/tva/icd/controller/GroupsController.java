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

import com.tva.icd.model.Groups;
import com.tva.icd.service.GroupsService;

@RestController
public class GroupsController {

	@Autowired
	private GroupsService groupsService;

	public GroupsController() {
		System.out.println("Starting groups controller");
	}

	@RequestMapping(value = "/groups/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Groups>> listAllGroupss() {
		
		System.out.println("listAllGroupss ResponseEntity");
		List<Groups> groups = groupsService.getAllGroupss();
		
		groups.stream().forEach(group -> System.out.println(group.toString()));

		if (groups.isEmpty()) {
			return new ResponseEntity<List<Groups>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);

	}

	@RequestMapping(value = "/groups/{chapterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Groups>> getGroups(@PathVariable("chapterId") Integer chapterId) {
		System.out.println("Fetching Groups with id " + chapterId);
		List<Groups> groups = groupsService.getGroupsByChapter(chapterId);
		groups.stream().forEach(group -> System.out.println(group.toString()));
		
		if (groups.isEmpty()) {
			return new ResponseEntity<List<Groups>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);
	}

}