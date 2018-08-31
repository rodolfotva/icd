package com.tva.icd.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "chapterPt")
public class ChapterPt {

	@Id
	private ObjectId objectId;
	@Field("id")
	private String id;
	@Field("desc")
	private String descripion;

	public ChapterPt() {
		super();
	}

	public ChapterPt(String id, String descripion) {
		super();
		this.id = id;
		this.descripion = descripion;
	}

	public ChapterPt(ObjectId objectId, String id, String descripion) {
		super();
		this.objectId = objectId;
		this.id = id;
		this.descripion = descripion;
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

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	@Override
	public String toString() {
		return "Chapter [ObjectId=" + objectId + ", id=" + id + ", descripion=" + descripion + "]";
	}

}
