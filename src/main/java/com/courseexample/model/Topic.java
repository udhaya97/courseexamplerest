package com.courseexample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
public class Topic {
	@Id
	private String toId;
	private String toName;
	private String toDescription;
	
	  @OneToMany(mappedBy = "topic",cascade = CascadeType.REMOVE) private
	  List<Course> courses;
	 
	
	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getToDescription() {
		return toDescription;
	}

	public void setToDescription(String toDescription) {
		this.toDescription = toDescription;
	}

	/*
	 * public List<Course> getCourses() { return courses; }
	 * 
	 * public void setCourses(List<Course> courses) { this.courses = courses; }
	 */
	
	

	public Topic(String toId, String toName, String toDescription) {
		super();
		this.toId = toId;
		this.toName = toName;
		this.toDescription = toDescription;
	}

	/*
	 * public Topic(String toId, String toName, String toDescription, List<Course>
	 * courses) { super(); this.toId = toId; this.toName = toName;
	 * this.toDescription = toDescription; this.courses = courses; }
	 */
	public Topic() {
		
	}
	
	
	

}
