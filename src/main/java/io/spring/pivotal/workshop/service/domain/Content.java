package io.spring.pivotal.workshop.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content")
public class Content {

	@Id
	@Column(length = 40)
	private String courseID;

	private String title;
	private String section;
	private String description;
	private String slideURL;
	private String labURL;

	public Content() {
	}

	public Content(String courseID, String title, String section, String description, String slideURL, String labURL) {
		this.courseID = courseID;
		this.title = title;
		this.section = section;
		this.description = description;
		this.slideURL = slideURL;
		this.labURL = labURL;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSlideURL() {
		return slideURL;
	}

	public void setSlideURL(String slideURL) {
		this.slideURL = slideURL;
	}

	public String getLabURL() {
		return labURL;
	}

	public void setLabURL(String labURL) {
		this.labURL = labURL;
	}
}
