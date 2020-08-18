package com.courseexample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.courseexample.model.Course;
@Repository
public interface CourseDao {


	

boolean saveCourse(Course course);

boolean updateCourse(Course course);

List<Course> getAllCourse(String tId);

Course getCourse(String tId, String cId);

boolean deleteCourse(String tId, String cId);
	
}
