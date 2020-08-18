package com.courseexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.courseexample.model.Lesson;
@Service
public interface LessonService {

	boolean saveLesson(Lesson lesson);

	boolean updateLesson(Lesson lesson);

	List<Lesson> getAllLesson(String coId);

	Lesson getLesson(String lesId, String coId);

	boolean deleteLesson(String lesId, String coId);

}
