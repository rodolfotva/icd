package com.tva.icd.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.Chapter;
import com.tva.icd.model.ChapterToGroups;

@Repository
public class ChapterDapImpl implements ChapterDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addChapter(Chapter chapter) {
		sessionFactory.getCurrentSession().saveOrUpdate(chapter);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Chapter> getAllChapters() {
		return sessionFactory.getCurrentSession().createQuery("from Chapter").list();
	}

	@Override
	public void deleteChapter(Integer chapterId) {
		sessionFactory.getCurrentSession().delete(getChapter(chapterId));
	}

	@Override
	public Chapter updateChapter(Chapter chapter) {
		sessionFactory.getCurrentSession().update(chapter);
		return chapter;
	}

	@Override
	public Chapter getChapter(Integer chapterId) {
		return (Chapter) sessionFactory.getCurrentSession().get(Chapter.class, chapterId);
	}

}
