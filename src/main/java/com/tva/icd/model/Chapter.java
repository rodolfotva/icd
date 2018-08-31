package com.tva.icd.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "chapter")
public class Chapter {

	@Id
	private ObjectId objectId;
	@Field("id")
	private String id;
	@Field("desc")
	private String descripion;
	@Field("inc")
	private List<String> includes;
	@Field("addNote")
	private List<String> addNotes;
	@Field("exc")
	private List<String> exludes;

	public Chapter() {
		super();
	}

	public Chapter(String id, String descripion, List<String> includes, List<String> addNotes, List<String> exludes) {
		super();
		this.id = id;
		this.descripion = descripion;
		this.includes = includes;
		this.addNotes = addNotes;
		this.exludes = exludes;
	}

	public Chapter(ObjectId objectId, String id, String descripion, List<String> includes, List<String> addNotes,
			List<String> exludes) {
		super();
		this.objectId = objectId;
		this.id = id;
		this.descripion = descripion;
		this.includes = includes;
		this.addNotes = addNotes;
		this.exludes = exludes;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		objectId = objectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public List<String> getIncludes() {
		return includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

	public List<String> getAddNotes() {
		return addNotes;
	}

	public void setAddNotes(List<String> addNotes) {
		this.addNotes = addNotes;
	}

	public List<String> getExludes() {
		return exludes;
	}

	public void setExludes(List<String> exludes) {
		this.exludes = exludes;
	}

	@Override
	public String toString() {
		return "Chapter [ObjectId=" + objectId + ", id=" + id + ", descripion=" + descripion + "]";
	}

}
