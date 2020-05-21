package com.tva.icd.service;

import java.util.List;
import com.tva.icd.model.Chapter;

public interface ChapterService {

  public void addChapter(Chapter chapter);

  public List<Chapter> getAllChapters(String locale);

  public void deleteChapter(Chapter chapter);

  public Chapter updateChapter(Chapter chapter);

  public Chapter getChapter(String objectId);

  public Chapter getChapterBtId(String id);
}
