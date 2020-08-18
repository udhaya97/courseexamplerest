package com.courseexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseexample.model.Lesson;
@Repository
public class LessonDaoImpl implements LessonDao {

	@Autowired
	LessonRepo lessRepo;
	
	
	@Override
	public boolean saveLesson(Lesson lesson) {
		lessRepo.save(lesson);
		return true;
	}

	@Override
	public boolean updateLesson(Lesson lesson) {
		lessRepo.save(lesson);
		return true;
	}

	@Override
	public List<Lesson> getAllLesson(String coId) {
		List<Lesson> lessonLis = lessRepo.findByCourseCoId(coId);
		return lessonLis;
	}

	@Override
	public Lesson getLesson(String lesId, String courseCoId) {
		Lesson less = lessRepo.findByLesIdAndCourseCoId(lesId, courseCoId);
		return less;
	}

	@Override
	public boolean deleteLesson(String lesId, String courseCoId) {
		lessRepo.deleteByLesIdAndCourseCoId(lesId, courseCoId);
		return true;
	}

}
