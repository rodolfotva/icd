package com.tva.icd.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class SubGroup {

  private String name;
  @Field("desc")
  private String description;
  
  public SubGroup() {
    super();
  }

  public SubGroup(String name, String description) {
    super();
    this.name = name;
    this.description = description;
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



}
