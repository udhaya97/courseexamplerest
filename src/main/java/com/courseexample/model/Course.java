package com.courseexample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course {

	@Id
	private String coId;
	private String coName;
	private String coDescription;
	@ManyToOne
	@JoinColumn(name="topic")
	private Topic topic;
	
	@OneToMany(mappedBy = "course",cascade = CascadeType.REMOVE) 
	private
	  List<Lesson> lesson;
	
	public String getCoId() {
		return coId;
	}

	public void setCoId(String coId) {
		this.coId = coId;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getCoDescription() {
		return coDescription;
	}

	public void setCoDescription(String coDescription) {
		this.coDescription = coDescription;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Course(String coId, String coName, String coDescription, Topic topic) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coDescription = coDescription;
		this.topic = topic;
	}

	public Course() {
		super();
	}
	
}
