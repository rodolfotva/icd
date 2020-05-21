package com.tva.icd.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "categoryPt")
public class CategoryPt {

  @Id
  private ObjectId ObjectId;
  @Field("id")
  private String id;
  @Field("fst")
  private String first;
  @Field("lst")
  private String last;
  private String title;
  @Field("chId")
  private String chapterId;

  public CategoryPt() {
    super();
  }

  public CategoryPt(String id, String first, String last, String title, String chapterId) {
    super();
    this.id = id;
    this.first = first;
    this.last = last;
    this.title = title;
    this.chapterId = chapterId;

  }

  public ObjectId getObjectId() {
    return ObjectId;
  }

  public void setObjectId(ObjectId objectId) {
    ObjectId = objectId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getChapterId() {
    return chapterId;
  }

  public void setChapterId(String chapterId) {
    this.chapterId = chapterId;
  }

}
