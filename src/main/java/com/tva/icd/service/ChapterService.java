package com.tva.icd.service;

import java.util.List;

import com.tva.icd.model.Chapter;

public interface ChapterService {

	public void addChapter(Chapter chapter);
	public List<Chapter> getAllChapters();
	public void deleteChapter(Integer chapterId);
	public Chapter updateChapter(Chapter chapter);
	public Chapter getChapter(Integer chapterId);
	
}
