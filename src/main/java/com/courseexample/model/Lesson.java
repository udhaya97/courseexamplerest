package com.courseexample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Lesson {

	@Id
	private String lesId;
	private String lesName;
	private String lesDescription;
	@ManyToOne
	@JoinColumn(name = "course")
	private Course course;
	public String getLesId() {
		return lesId;
	}
	public void setLesId(String lesId) {
		this.lesId = lesId;
	}
	public String getLesName() {
		return lesName;
	}
	public void setLesName(String lesName) {
		this.lesName = lesName;
	}
	public String getLesDescription() {
		return lesDescription;
	}
	public void setLesDescription(String lesDescription) {
		this.lesDescription = lesDescription;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Lesson(String lesId, String lesName, String lesDescription, Course course) {
		super();
		this.lesId = lesId;
		this.lesName = lesName;
		this.lesDescription = lesDescription;
		this.course = course;
	}
	public Lesson() {
		super();
	}
	
	
}
