package com.courseexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.courseexample.dao.CourseDao;
import com.courseexample.model.Course;
@Service
public class CourseServiceImpl implements Courseservice {

	@Autowired
	CourseDao cDao;

	
	@Override
	public boolean saveCourse(Course course) {
		cDao.saveCourse(course);
		return true;
	}

	@Override
	public boolean updateCourse(Course course) {
		cDao.updateCourse(course);
		return true;
	}

	@Override
	public List<Course> getAllCourse(String tId) {

List<Course> lisCo = cDao.getAllCourse(tId);
		
		return lisCo;
	}

	@Override
	public Course getCourse(String tId, String cId) {
		Course co = cDao.getCourse(tId, cId);
		return co;
	}

	@Override
	public boolean deleteCourse(String tId, String cId) {
		cDao.deleteCourse(tId, cId);
		return true;
	}
	
	
	

}
