package com.tva.icd.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "chapterFr")
public class ChapterFr {

	@Id
	private ObjectId objectId;
	@Field("id")
	private String id;
	@Field("desc")
	private String descripion;

	public ChapterFr() {
		super();
	}

	public ChapterFr(String id, String descripion) {
		super();
		this.id = id;
		this.descripion = descripion;
	}

	public ChapterFr(ObjectId objectId, String id, String descripion) {
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
