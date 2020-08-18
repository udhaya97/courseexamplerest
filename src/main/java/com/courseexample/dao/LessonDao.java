package com.courseexample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.courseexample.model.Course;
import com.courseexample.model.Lesson;
@Repository
public interface LessonDao {

	boolean saveLesson(Lesson lesson);

	boolean updateLesson(Lesson lesson);

	List<Lesson> getAllLesson(String coId);

	Lesson getLesson(String lesId, String coId);

	boolean deleteLesson(String lesId, String coId);
	
}
