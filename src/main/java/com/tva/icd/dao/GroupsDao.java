package com.tva.icd.dao;

import java.util.List;

import com.tva.icd.model.Groups;

public interface GroupsDao {
	
	public void addGroups(Groups groups);
	public List<Groups> getAllGroupss();
	public void deleteGroups(Integer groupsId);
	public Groups updateGroups(Groups groups);
	public Groups getGroups(Integer groupsId);
	public List<Groups> getGroupsByChapter(Integer chapterId);
	
}
