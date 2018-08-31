package com.tva.icd.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.model.Chapter;
import com.tva.icd.repositories.ChapterFrRepository;
import com.tva.icd.repositories.ChapterPtRepository;
import com.tva.icd.repositories.ChapterRepository;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepo;
	@Autowired
	private ChapterPtRepository chapterPtRepo;
	@Autowired
	private ChapterFrRepository chapterFrRepo;

	@Override
	public void addChapter(Chapter chapter) {
		chapterRepo.insert(chapter);
	}

	@Override
	public List<Chapter> getAllChapters(String locale) {
		switch (locale) {
		case "en":
			return chapterRepo.findAll();
		case "pt":
			List<Chapter> temp = new LinkedList<>();
			chapterPtRepo.findAll().stream().forEach(cha -> {
				temp.add(new Chapter(cha.getObjectId(), cha.getId(), cha.getDescripion(), null, null, null));
			});
			return temp;
		case "fr":
			List<Chapter> tempFr = new LinkedList<>();
			chapterFrRepo.findAll().stream().forEach(cha -> {
				tempFr.add(new Chapter(cha.getObjectId(), cha.getId(), cha.getDescripion(), null, null, null));
			});
			return tempFr;
		default:
			return chapterRepo.findAll();
		}
	}

	@Override
	public void deleteChapter(Chapter chapter) {
		chapterRepo.delete(chapter);
	}

	@Override
	public Chapter updateChapter(Chapter chapter) {
		Chapter chapterTmp = chapterRepo.save(chapter);
		return chapterTmp;
	}

	@Override
	public Chapter getChapter(String objectId) {
		return chapterRepo.findByid(objectId);
	}

	@Override
	public Chapter getChapterBtId(String id) {
		return chapterRepo.findByid(id);
	}

}
