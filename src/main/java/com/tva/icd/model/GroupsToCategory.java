package com.tva.icd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Groups")
public class GroupsToCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int groupId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="chapterId")
	private ChapterToGroups chapter;
	
	@Column
	private String catini; 
	
	@Column
	private String catfin;
	
	@Column
	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
	private List<CategoryTo> categorys;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public ChapterToGroups getChapter() {
		return chapter;
	}

	public void setChapter(ChapterToGroups chapter) {
		this.chapter = chapter;
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

	public List<CategoryTo> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<CategoryTo> categorys) {
		this.categorys = categorys;
	}

	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", catini=" + catini + ", catfin=" + catfin + ", description=" + description + "]";
	}
	
	

}
