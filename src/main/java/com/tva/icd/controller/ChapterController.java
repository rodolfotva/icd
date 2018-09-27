package com.tva.icd.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tva.icd.model.Chapter;
import com.tva.icd.service.ChapterService;

@RestController
public class ChapterController {

	@Autowired
	private ChapterService chapterService;

	private static final Logger logger = LogManager.getLogger(ChapterController.class.getName());

	public ChapterController() {
		logger.info("Initializing Chapter Controller");
	}

	@RequestMapping(value = "/chapter/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Chapter>> listAllChapters() {
		logger.info("listAllChapters ResponseEntity");
		List<Chapter> chapters = chapterService.getAllChapters(LocaleContextHolder.getLocale().getLanguage()).stream().sorted((u1, u2) -> u1.getId().compareTo(u2.getId())).collect(Collectors.toList());

		logger.info("Chapters found: " + chapters.size());
		// chapters.stream().forEach(chapter -> System.out.println(chapter));

		if (chapters.isEmpty()) {
			return new ResponseEntity<List<Chapter>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Chapter>>(chapters, HttpStatus.OK);

	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Chapter> getChapter(@PathVariable("chapterId") String chapterId) {
		logger.info("Fetching Chapter with id " + chapterId);

		Chapter chapter = chapterService.getChapter(chapterId);
		if (chapter == null) {
			System.out.println("Chapter with id " + chapterId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Chapter>(chapter, HttpStatus.OK);
	}

	@RequestMapping(value = "/chapter/", method = RequestMethod.POST)
	public ResponseEntity<Void> createChapter(@RequestBody Chapter chapter, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Chapter " + chapter.getId());

		if (Objects.nonNull(chapterService.getChapter(chapter.getObjectId().toString()))) {
			logger.info("A Chapter with number " + chapter.getId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		chapterService.addChapter(chapter);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/chapter/{id}").buildAndExpand(chapter.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.PUT)
	public ResponseEntity<Chapter> updateChapter(@PathVariable("chapterId") String chapterId,
			@RequestBody Chapter chapter) {
		logger.info("Updating Chapter " + chapterId);

		Chapter currentChapter = chapterService.getChapter(chapterId);

		if (currentChapter == null) {
			System.out.println("Chapter with id " + chapterId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}

		currentChapter.setId(chapter.getId());
		// currentChapter.setCatini(chapter.getCatini());
		// currentChapter.setCatfin(chapter.getCatfin());
		currentChapter.setDescripion(chapter.getDescripion());

		chapterService.updateChapter(currentChapter);
		return new ResponseEntity<Chapter>(currentChapter, HttpStatus.OK);
	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.DELETE)
	public ResponseEntity<Chapter> deleteChapter(@PathVariable("chapterId") String objectId) {
		logger.info("Fetching & Deleting Chapter with id " + objectId);

		Chapter chapter = chapterService.getChapter(objectId);
		if (chapter == null) {
			logger.info("Unable to delete. Chapter with id " + objectId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}

		chapterService.deleteChapter(chapter);
		return new ResponseEntity<Chapter>(HttpStatus.NO_CONTENT);
	}

}