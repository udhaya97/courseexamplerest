package com.courseexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseexample.dao.LessonDao;
import com.courseexample.model.Lesson;
@Service
public class LessonServiceInpl implements LessonService {

	
	@Autowired
	LessonDao lessDao;
	
	@Override
	public boolean saveLesson(Lesson lesson) {
		lessDao.saveLesson(lesson);
		return true;
	}

	@Override
	public boolean updateLesson(Lesson lesson) {
		lessDao.saveLesson(lesson);
		return true;
	}

	@Override
	public List<Lesson> getAllLesson(String coId) {
		List<Lesson> lis = lessDao.getAllLesson(coId);
		return lis;
	}

	@Override
	public Lesson getLesson(String lesId, String coId) {
		Lesson les = lessDao.getLesson(lesId, coId);
		return les;
	}

	@Override
	public boolean deleteLesson(String lesId, String coId) {
		lessDao.deleteLesson(lesId, coId);
		return true;
	}

}
