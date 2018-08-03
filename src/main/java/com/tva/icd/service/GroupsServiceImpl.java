package com.tva.icd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.dao.GroupsDao;
import com.tva.icd.model.Groups;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService {

	@Autowired
	private GroupsDao groupsDao;
	
	@Override
	@Transactional
	public void addGroups(Groups groups) {
		groupsDao.addGroups(groups);
	}

	@Override
	@Transactional
	public List<Groups> getAllGroupss() {
		return groupsDao.getAllGroupss();
	}

	@Override
	@Transactional
	public void deleteGroups(Integer groupsId) {
		groupsDao.deleteGroups(groupsId);
	}

	@Override
	@Transactional
	public Groups updateGroups(Groups groups) {
		return groupsDao.updateGroups(groups);
	}

	@Override
	@Transactional
	public Groups getGroups(Integer groupsId) {
		return groupsDao.getGroups(groupsId);
	}

	@Override
	@Transactional
	public List<Groups> getGroupsByChapter(Integer chapterId) {
		return groupsDao.getGroupsByChapter(chapterId);
	}

}
