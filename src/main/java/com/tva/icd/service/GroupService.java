package com.tva.icd.service;

import java.util.List;
import com.tva.icd.model.Category;
import com.tva.icd.model.Group;
import com.tva.icd.model.SubGroup;

public interface GroupService {

  public void addGroup(Group group);

  public List<Group> getAllGroups();

  public void deleteGroup(Group group);

  public Group updateGroup(Category group);

  public Group getGroup(String objectId);

  public List<Group> getGroupByName(String name, String locale);

  public List<Group> getGroupByDesc(String desc, String locale);

  public List<Group> getGroupByCategory(String categoryId, String locale);

  public Group findBySubGroup(String name);

  public List<SubGroup> findSubGroup(String name);

  List<Group> findLikeSubGroupDesc(String subGrpDesc, String locale);

}
