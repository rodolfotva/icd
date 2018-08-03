package com.tva.icd.dao;

import java.util.List;

import com.tva.icd.model.Chapter;

public interface ChapterDao {
	
	public void addChapter(Chapter chapter);
	public List<Chapter> getAllChapters();
	public void deleteChapter(Integer chapterId);
	public Chapter updateChapter(Chapter chapter);
	public Chapter getChapter(Integer chapterId);
	
}
