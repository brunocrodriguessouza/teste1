package com.ciandt.beveragecontrolapi.filter;

import com.ciandt.beveragecontrolapi.model.Section;

public class BeverageFilter {

	private String description;

	private Section section;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
