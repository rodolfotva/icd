package com.tva.icd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Groups")
public class Groups {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groupId;

	@Column
	private int chapterId;
	
	@Column
	private String catini; 
	
	@Column
	private String catfin;
	
	@Column
	private String description;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getCatini() {
		return catini;
	}

	public void setCatini(String catini) {
		this.catini = catini;
	}

	public String getCatfin() {
		return catfin;
	}

	public void setCatfin(String catfin) {
		this.catfin = catfin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", catini=" + catini + ", catfin=" + catfin + ", description=" + description + "]";
	}
	
}
