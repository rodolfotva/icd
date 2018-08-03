package com.tva.icd.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Chapter")
public class ChapterToGroups {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chapterId;
	
	@Column
	private String numchap; 
	
	@Column
	private String catini; 
	
	@Column
	private String catfin;
	
	@Column
	private String description;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="chapter")
	private List<GroupsToCategory> groups;

	public int getChapterId() {
		return chapterId;
	}
	

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getNumchap() {
		return numchap;
	}

	public void setNumchap(String numchap) {
		this.numchap = numchap;
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


	public List<GroupsToCategory> getGroups() {
		return groups;
	}


	public void setGroups(List<GroupsToCategory> groups) {
		this.groups = groups;
	}


	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", numchap=" + numchap + ", catini=" + catini + ", catfin=" + catfin + ", description=" + description + "]";
	}
	
}
