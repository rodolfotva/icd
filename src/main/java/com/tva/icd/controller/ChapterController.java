package com.tva.icd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tva.icd.model.Chapter;
import com.tva.icd.service.ChapterService;

@RestController
public class ChapterController {

	@Autowired
	private ChapterService chapterService;

	public ChapterController() {
		System.out.println("Starting chapter controller");
	}

	@RequestMapping(value = "/chapter/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Chapter>> listAllChapters() {
		
		System.out.println("listAllChapters ResponseEntity");
		List<Chapter> chapters = chapterService.getAllChapters();
		
		chapters.stream().forEach(chapter -> System.out.println(chapter.toString()));

		if (chapters.isEmpty()) {
			return new ResponseEntity<List<Chapter>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Chapter>>(chapters, HttpStatus.OK);

	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Chapter> getChapter(@PathVariable("chapterId") Integer chapterId) {
		
		System.out.println("Fetching Chapter with id " + chapterId);
		
		Chapter chapter = chapterService.getChapter(chapterId);
		if (chapter == null) {
			System.out.println("Chapter with id " + chapterId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Chapter>(chapter, HttpStatus.OK);
	}

	@RequestMapping(value = "/chapter/", method = RequestMethod.POST)
	public ResponseEntity<Void> createChapter(@RequestBody Chapter chapter, UriComponentsBuilder ucBuilder) {
		
		System.out.println("Creating Chapter " + chapter.getNumchap());

		if (chapterService.getChapter(chapter.getChapterId()) != null) {
			System.out.println("A Chapter with number " + chapter.getNumchap() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		chapterService.addChapter(chapter);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/chapter/{id}").buildAndExpand(chapter.getChapterId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.PUT)
	public ResponseEntity<Chapter> updateChapter(@PathVariable("chapterId") Integer chapterId,@RequestBody Chapter chapter) {
		
		System.out.println("Updating Chapter " + chapterId);

		Chapter currentChapter = chapterService.getChapter(chapterId);

		if (currentChapter == null) {
			System.out.println("Chapter with id " + chapterId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}

		currentChapter.setNumchap(chapter.getNumchap());
		currentChapter.setCatini(chapter.getCatini());
		currentChapter.setCatfin(chapter.getCatfin());
		currentChapter.setDescription(chapter.getDescription());

		chapterService.updateChapter(currentChapter);
		return new ResponseEntity<Chapter>(currentChapter, HttpStatus.OK);
	}

	@RequestMapping(value = "/chapter/{chapterId}", method = RequestMethod.DELETE)
	public ResponseEntity<Chapter> deleteChapter(@PathVariable("chapterId") Integer chapterId) {
		System.out.println("Fetching & Deleting Chapter with id " + chapterId);

		Chapter chapter = chapterService.getChapter(chapterId);
		if (chapter == null) {
			System.out.println("Unable to delete. Chapter with id " + chapterId + " not found");
			return new ResponseEntity<Chapter>(HttpStatus.NOT_FOUND);
		}

		chapterService.deleteChapter(chapterId);
		return new ResponseEntity<Chapter>(HttpStatus.NO_CONTENT);
	}

}