package com.tva.icd.controller;

import java.util.ArrayList;
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

import com.tva.icd.model.Group;
import com.tva.icd.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService groupService;

	private static final Logger logger = LogManager.getLogger(GroupController.class.getName());

	public GroupController() {
		logger.info("Initializing Group Controller");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Group>> listAllCategorys() {
		logger.info("listAllGroups ResponseEntity");
		List<Group> groupLst = groupService.getAllGroups();

		if (Objects.isNull(groupLst) || groupLst.isEmpty()) {
			return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Categorys found: " + groupLst.size());
		return new ResponseEntity<List<Group>>(groupLst, HttpStatus.OK);

	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getGroupsByChapterandCategory(@PathVariable("categoryId") String categoryId) {
		logger.info("Fetching Groups with Category Id " + categoryId);
		Map<String, Object> values = new HashMap<String, Object>();

		List<Group> groupLst = groupService.getGroupByCategory(categoryId, LocaleContextHolder.getLocale().getLanguage()).stream().sorted((u1, u2) -> u1.getId().compareTo(u2.getId())).collect(Collectors.toList());
		values.put("groupLst", groupLst);
		values.put("categoryId", categoryId);

		if (Objects.isNull(groupLst) || groupLst.isEmpty()) {
			logger.info("Group List from Category Id " + categoryId + " not found");
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Groups found: " + groupLst.size());
		return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/icd/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Group>> getSearchByIcd(@PathVariable("value") String value) {
		logger.info("Searching Group by icd " + value);
		List<Group> groups = new ArrayList<Group>();
		groups = groupService.getGroupByName(".*" + value.toUpperCase().trim() + ".*", LocaleContextHolder.getLocale().getLanguage());

		if (Objects.isNull(groups) || groups.isEmpty()) {
			logger.info("Group by icd: " + value + " not found");
			return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Group found: " + groups.size());
		return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/description/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Group>> getSearchByDescription(@PathVariable("value") String value) {
		logger.info("Searching Group by description " + value);

		final List<Group> groups = groupService.getGroupByDesc(".*" + value.trim() + ".*", LocaleContextHolder.getLocale().getLanguage());
		final List<Group> subGroups = groupService.findLikeSubGroupDesc(".*" + value.trim() + ".*", LocaleContextHolder.getLocale().getLanguage());

		List<Group> groupOutput = groups.stream().filter(gr -> subGroups.stream().map(Group::getName).anyMatch(name -> name.equals(gr.getName()))).collect(Collectors.toList());

		if (Objects.isNull(groupOutput) || groupOutput.isEmpty()) {
			logger.info("Group by description: " + value + " not found");
			return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Group found: " + groupOutput.size());
		return new ResponseEntity<List<Group>>(groupOutput, HttpStatus.OK);
	}

}