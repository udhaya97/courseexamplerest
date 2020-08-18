package com.courseexample.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.courseexample.model.Course;

@Service
public interface Courseservice {

	

	boolean saveCourse(Course course);

	boolean updateCourse(Course course);

	List<Course> getAllCourse(String tId);

	Course getCourse(String tId, String cId);

	boolean deleteCourse(String tId, String cId);

}
