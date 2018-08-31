package com.tva.icd.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.icd.model.Category;
import com.tva.icd.model.Group;
import com.tva.icd.model.SubGroup;
import com.tva.icd.repositories.GroupFrRepository;
import com.tva.icd.repositories.GroupPtRepository;
import com.tva.icd.repositories.GroupRepository;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepo;
	@Autowired
	private GroupPtRepository groupPtRepo;
	@Autowired
	private GroupFrRepository groupFrRepo;

	@Override
	public void addGroup(Group group) {

	}

	@Override
	public List<Group> getAllGroups() {
		return groupRepo.findAll();
	}

	@Override
	public void deleteGroup(Group group) {

	}

	@Override
	public Group updateGroup(Category group) {
		return null;
	}

	@Override
	public Group getGroup(String objectId) {
		return null;
	}

	@Override
	public List<Group> getGroupByCategory(String categoryId, String locale) {
		switch (locale) {
		case "en":
			return groupRepo.findByCategoryid(categoryId);
		case "pt":
			List<Group> temp = new LinkedList<Group>();
			groupPtRepo.findByCategoryid(categoryId).stream().forEach(grp -> {
				temp.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return temp;
		case "fr":
			List<Group> tempFr = new LinkedList<Group>();
			groupFrRepo.findByCategoryid(categoryId).stream().forEach(grp -> {
				tempFr.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return tempFr;
		default:
			return groupRepo.findByCategoryid(categoryId);
		}

	}

	@Override
	public Group findBySubGroup(String name) {
		return groupRepo.findSubGroup(name);
	}

	@Override
	public List<SubGroup> findSubGroup(String name) {
		Group group = groupRepo.findSubGroup(name);
		return group.getSubGroups();
	}

	@Override
	public List<Group> getGroupByName(String name, String locale) {
		switch (locale) {
		case "en":
			return groupRepo.findByName(name);
		case "pt":
			List<Group> temp = new LinkedList<Group>();
			groupPtRepo.findByName(name).stream().forEach(grp -> {
				temp.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return temp;
		case "fr":
			List<Group> tempFr = new LinkedList<Group>();
			groupFrRepo.findByName(name).stream().forEach(grp -> {
				tempFr.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return tempFr;
		default:
			return groupRepo.findByName(name);
		}
	}

	@Override
	public List<Group> getGroupByDesc(String desc, String locale) {
		switch (locale) {
		case "en":
			return groupRepo.findByDescription(desc);
		case "pt":
			List<Group> temp = new LinkedList<Group>();
			groupPtRepo.findByDescription(desc).stream().forEach(grp -> {
				temp.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return temp;
		case "fr":
			List<Group> tempFr = new LinkedList<Group>();
			groupFrRepo.findByDescription(desc).stream().forEach(grp -> {
				tempFr.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return tempFr;
		default:
			return groupRepo.findByDescription(desc);
		}
	}

	@Override
	public List<Group> findLikeSubGroupDesc(String subGrpDesc, String locale) {
		switch (locale) {
		case "en":
			return groupRepo.findLikeSubGroupDesc(subGrpDesc);
		case "pt":
			List<Group> temp = new LinkedList<Group>();
			groupPtRepo.findLikeSubGroupDesc(subGrpDesc).stream().forEach(grp -> {
				temp.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return temp;
		case "fr":
			List<Group> tempFr = new LinkedList<Group>();
			groupFrRepo.findLikeSubGroupDesc(subGrpDesc).stream().forEach(grp -> {
				tempFr.add(new Group(grp.getObjectId(), grp.getId(), grp.getName(), grp.getDescription(),
						grp.getSubGroups()));
			});
			return tempFr;
		default:
			return groupRepo.findLikeSubGroupDesc(subGrpDesc);
		}
	}

}
