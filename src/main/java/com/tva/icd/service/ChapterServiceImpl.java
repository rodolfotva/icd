package com.tva.icd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.dao.ChapterDao;
import com.tva.icd.model.Chapter;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterDao chapterDao;
	
	@Override
	@Transactional
	public void addChapter(Chapter chapter) {
		chapterDao.addChapter(chapter);
	}

	@Override
	@Transactional
	public List<Chapter> getAllChapters() {
		return chapterDao.getAllChapters();
	}

	@Override
	@Transactional
	public void deleteChapter(Integer chapterId) {
		chapterDao.deleteChapter(chapterId);
	}

	@Override
	@Transactional
	public Chapter updateChapter(Chapter chapter) {
		return chapterDao.updateChapter(chapter);
	}

	@Override
	@Transactional
	public Chapter getChapter(Integer chapterId) {
		return chapterDao.getChapter(chapterId);
	}

}
