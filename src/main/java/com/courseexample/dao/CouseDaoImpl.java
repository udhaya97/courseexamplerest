package com.courseexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Course;
import com.courseexample.model.Topic;
@Repository
public class CouseDaoImpl implements CourseDao {

	@Autowired
	
	CourseRepo  courseRepo;

	

	@Override
	public boolean saveCourse(Course course) {
		courseRepo.save(course);
		return true;
	}

	@Override
	public boolean updateCourse(Course course) {
		
		courseRepo.save(course);
		
		return true;
	}

	@Override
	public List<Course> getAllCourse(String topicToId) {
		List<Course> lisCourse = courseRepo.findByTopicToId(topicToId);
		return lisCourse;
	}

	@Override
	public Course getCourse(String topicToId, String coId) {
		Course cour = courseRepo.findByCoIdAndTopicToId(coId,topicToId);
		return cour;
	}

	@Override
	public boolean deleteCourse(String topicToId, String coId) {
		courseRepo.deleteByCoIdAndTopicToId(coId,topicToId);
		return true;
	}

	
	

}
