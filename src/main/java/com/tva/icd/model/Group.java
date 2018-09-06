package com.tva.icd.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "group")
public class Group {

	@Id
	private ObjectId objectId;
	private String id;
	private String name;
	@Field("desc")
	private String description;
	@Field("catId")
	private String categoryId;
	private List<SubGroup> subGroups;

	public Group() {
		super();
	}

	public Group(String id, String name, String description, List<SubGroup> subGroups) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.subGroups = subGroups;
	}

	public Group(ObjectId objectId, String id, String name, String description, List<SubGroup> subGroups) {
		super();
		this.objectId = objectId;
		this.id = id;
		this.name = name;
		this.description = description;
		this.subGroups = subGroups;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<SubGroup> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(List<SubGroup> subGroups) {
		this.subGroups = subGroups;
	}

}