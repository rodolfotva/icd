package com.tva.icd.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.Groups;

@Repository
public class GroupsDapImpl implements GroupsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addGroups(Groups groups) {
		sessionFactory.getCurrentSession().saveOrUpdate(groups);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Groups> getAllGroupss() {
		return sessionFactory.getCurrentSession().createQuery("from Groups").list();
	}

	@Override
	public void deleteGroups(Integer groupsId) {
		sessionFactory.getCurrentSession().delete(getGroups(groupsId));
	}

	@Override
	public Groups updateGroups(Groups groups) {
		sessionFactory.getCurrentSession().update(groups);
		return groups;
	}

	@Override
	public Groups getGroups(Integer groupsId) {
		return (Groups) sessionFactory.getCurrentSession().get(Groups.class, groupsId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Groups> getGroupsByChapter(Integer chapterId) {
		return sessionFactory.getCurrentSession().createQuery("from Groups where chapterId = :chapterId").setParameter("chapterId", chapterId).list();
	}

}
